/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Emmertia
 */
public class MainTest {
    
   

    // Patient Tests 
    @Test
    public void testPatientCreation() {
        Patient p = new Patient("P01", "John", "Doe", 25, "Male", "Flu", PatientCategory.Inpatient);
        assertEquals("P01", p.getPatientID());
        assertEquals("John", p.getFirstName());
        assertEquals(25, p.getAge());
        assertEquals(PatientCategory.Inpatient, p.getPatientCategory());
    }

    @Test
    public void testInpatientCreation() {
        Inpatient ip = new Inpatient("P02", "Jane", "Doe", 30, "Female", "Fever", "W1", "2026-08-24");
        assertTrue(ip instanceof Patient);
        assertEquals(PatientCategory.Inpatient, ip.getPatientCategory());
    }

    @Test
    public void testPatientManagementEmpty() {
        PatientManagement pm = new PatientManagement();
        assertEquals(0, pm.getTotalPatients());
        assertNull(pm.getPatientById("P999"));
    }

    // Bed Tests 
    @Test
    public void testBedAvailable() {
        Bed bed = new Bed("B01");
        assertTrue(bed.isAvailable());
        assertEquals("B01", bed.getBedId());
    }

    @Test
    public void testBedAllocation() {
        Bed bed = new Bed("B01");
        Patient p = new Patient("P01", "John", "Doe", 25, "Male", "Flu", PatientCategory.Inpatient);
        bed.allocate(p);
        assertFalse(bed.isAvailable());
        assertEquals("P01", bed.getPatient().getPatientID());
    }

    @Test
    public void testBedRelease() {
        Bed bed = new Bed("B01");
        Patient p = new Patient("P01", "John", "Doe", 25, "Male", "Flu", PatientCategory.Inpatient);
        bed.allocate(p);
        bed.release();
        assertTrue(bed.isAvailable());
    }

    //Ward Manager Tests
    @Test
    public void testWardManagerInitial() {
        PatientManagement pm = new PatientManagement();
        WardManager wm = new WardManager(pm);
        assertNotNull(wm);
        assertEquals(0, wm.getTotalOccupied());
    }
}