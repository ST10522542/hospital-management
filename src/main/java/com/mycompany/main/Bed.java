/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Emmertia
 */
public class Bed {
   
    private String bedId;
    private Patient patient;

    public Bed(String bedId) {
        this.bedId = bedId;
        this.patient = null;
    }
    public boolean isAvailable() { return patient == null; }
    public void allocate(Patient p) { this.patient = p; }
    public void release() { this.patient = null; }
    public String getBedId() { return bedId; }
    public Patient getPatient() { return patient; }
}
    

