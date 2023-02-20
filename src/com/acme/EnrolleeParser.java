package com.acme;

import java.io.*;
import java.util.*;

/**
 * Process CSV files to sort by insurance company and last name first name order
 */
public class EnrolleeParser {

    /**
     * read the list of enrollees off of a csv file
     *
     * @param filePath csv file path
     * @return List of enrollees
     * @throws IOException
     */
    public List<Enrollee> readEnrolleesFromFile(String filePath) throws IOException {
        List<Enrollee> enrollees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            Enrollee enrollee = new Enrollee(fields[0], fields[1], fields[2], fields[3], fields[4]);
            enrollees.add(enrollee);
        }
        br.close();
        return enrollees;
    }

    /**
     * separate enrollees by insurance company and sort by last and first name
     *
     * @param enrollees list of insurance enrollees
     * @throws IOException
     */
    public void parseEnrolleeListByCompany(List<Enrollee> enrollees) throws IOException {
        Map<String, List<Enrollee>> companyEnrollees = new HashMap<>();
        // go through the entire list of enrollees and put them in lists by company
        for (Enrollee enrollee : enrollees) {
            if (!companyEnrollees.containsKey(enrollee.insuranceCompany)) {
                companyEnrollees.put(enrollee.insuranceCompany, new ArrayList<>());
            }
            companyEnrollees.get(enrollee.insuranceCompany).add(enrollee);
        }
        //now we have a Map populated with key company and value List of all the members
        for (String company : companyEnrollees.keySet()) {
            HashMap<String, Enrollee> uniqueEnrollees = new HashMap<>();
            //filter out duplicates (older versions) by using a Map
            for (Enrollee enrollee : companyEnrollees.get(company)) {
                String key = enrollee.userId;
                if (!uniqueEnrollees.containsKey(key) || Integer.parseInt(enrollee.version) > Integer.parseInt(uniqueEnrollees.get(key).version)) {
                    uniqueEnrollees.put(key, enrollee);
                }
            }
            List<Enrollee> companyEnrolleesList = new ArrayList<>();

            for (Map.Entry<String, Enrollee> entry : uniqueEnrollees.entrySet()) {
                companyEnrolleesList.add(entry.getValue());
            }
            Collections.sort(companyEnrolleesList);
            writeToFile(company, companyEnrolleesList);
        }
    }

    /**
     * sort by Last then first name
     * @param enrolleeList
     */
    void sortEnrolleesByLastFirst(List<Enrollee> enrolleeList)
    {
        enrolleeList.sort(Comparator.comparing(Enrollee::getLastName).thenComparing(Enrollee::getFirstName));
    }

    /**
     * write out to a file
     * @param company
     * @param enrolleeList
     * @throws IOException
     */
    void writeToFile(String company, List<Enrollee> enrolleeList) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/data/" + company + ".csv"));
        pw.println("User Id,First Name,Last Name,Version,Insurance Company");
        for (Enrollee enrollee : enrolleeList) {
            pw.println(enrollee.userId + "," + enrollee.firstName + "," + enrollee.lastName + "," + enrollee.version + "," + enrollee.insuranceCompany);
        }
        pw.close();
    }
}
