package com.acme;

import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) {
            List<Enrollee> enrollees = null;
            EnrolleeParser parser = new EnrolleeParser();
            try {
                enrollees = parser.readEnrolleesFromFile("src/data/enrollees.csv");
            } catch (IOException e) {
                System.out.println("Encountered exception on reading operation");
                e.printStackTrace();
            }
            try {
                assert enrollees != null;
                parser.parseEnrolleeListByCompany(enrollees);
            } catch (IOException e) {
                System.out.println("Encountered exception on writing operation");
                e.printStackTrace();
            }
        }




}
