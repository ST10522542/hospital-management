/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Emmertia
 */
public class Patient {
   
    private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private PatientCategory patientCategory;
    private String allocatedBed = null;

    public Patient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory patientCategory) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.patientCategory = patientCategory;
    }
    public String getPatientID() { return patientID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public PatientCategory getPatientCategory() { return patientCategory; }
    public String getAllocatedBed() { return allocatedBed; }
    public void setFirstName(String s){ firstName=s; }
    public void setLastName(String s){ lastName=s; }
    public void setAge(int a){ age=a; }
    public void setMedicalCondition(String s){ medicalCondition=s; }
    public void setAllocatedBed(String b){ allocatedBed=b; }

    @Override
    public String toString() {
        String bed = (allocatedBed == null)? "No Bed" : allocatedBed;
        return "ID: " + patientID + " | Name: " + firstName + " " + lastName + " | Age: " + age + " | Cat: " + patientCategory + " | Bed: " + bed;
    }
}
    

