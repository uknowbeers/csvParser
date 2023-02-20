package com.acme;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class EnrolleesTest {

    EnrolleeParser sut = new EnrolleeParser();
    @Test
    public void testEnrolleesFileParsing() throws IOException {
        List<Enrollee> enrolleeList = sut.readEnrolleesFromFile("src/data/enrollees.csv");
        assertEquals(11, enrolleeList.size());
    }
    
    @Test
    public void testEnrolleeSorting() {

        Enrollee enrollee1 = new Enrollee("1", "Jim", "Zebra", "1", "Aetna");
        Enrollee enrollee2 = new Enrollee("2", "Zychinski", "Jim", "1", "Aetna");
        Enrollee enrollee3 = new Enrollee("5", "Jon", "Pecc", "1", "Aetna");
        Enrollee enrollee4 = new Enrollee("79", "Peco", "Jonathan", "1", "Aetna");
        Enrollee enrollee5 = new Enrollee("999", "Sarah", "Aly", "1", "Aetna");

        List<Enrollee> myList = new ArrayList<>();
        myList.add(enrollee1);
        myList.add(enrollee2);
        myList.add(enrollee3);
        myList.add(enrollee4);
        myList.add(enrollee5);

        Collections.sort(myList);

        assertEquals("Aly", myList.get(0).getLastName());
        assertEquals("Zebra", myList.get(4).getLastName());
    }
    
//    @Test
//    public void testInsuranceCompanySeparation() throws IOException {
//        List<Enrollee> enrolleeList = sut.readEnrolleesFromFile("src/data/enrollees.csv");
//
//        enrollees.separateEnrolleesByInsuranceCompany();
//        assertEquals(2, enrollees.getEnrolleesByInsuranceCompany().size());
//        assertTrue(enrollees.getEnrolleesByInsuranceCompany().containsKey("Aetna"));
//        assertTrue(enrollees.getEnrolleesByInsuranceCompany().containsKey("UnitedHealthcare"));
//    }
    
//    @Test
//    public void testDuplicateEnrolleeRemoval() throws IOException {
//        List<Enrollee> enrolleeList = sut.readEnrolleesFromFile("src/data/enrollees.csv");
//
//        enrollees.removeDuplicateEnrollees();
//        assertEquals(4, enrollees.getEnrollees().size());
//    }

}
