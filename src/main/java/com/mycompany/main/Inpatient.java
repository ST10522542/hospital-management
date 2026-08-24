/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Emmertia
 */

    
public class Inpatient extends Patient {
    private String wardNumber;
    private String admissionDate;

    public Inpatient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition, String wardNumber, String admissionDate) {
        super(patientID, firstName, lastName, age, gender, medicalCondition, PatientCategory.Inpatient);
        this.wardNumber = wardNumber;
        this.admissionDate = admissionDate;
    }
    @Override
    public String toString() {
        return super.toString() + " | Ward: " + wardNumber + " | Admitted: " + admissionDate;
    }
}
    

