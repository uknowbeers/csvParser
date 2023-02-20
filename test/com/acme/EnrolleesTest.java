package com.acme;

import org.junit.Test;

import java.io.IOException;
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
//        List<Enrollee> enrolleeList = sut.readEnrolleesFromFile("src/data/enrollees.csv");
//        assertEquals("Doe", enrolleeList.get(0).getLastName());
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
