/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Emmertia
 */
public class PatientManagement {
     private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void registerPatient() {
        System.out.print("Enter Patient ID: "); String id = sc.nextLine();
        if (findPatientById(id)!= null) { System.out.println("ID already exists!"); return; }
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
        System.out.print("Gender: "); String gender = sc.nextLine();
        System.out.print("Medical Condition: "); String cond = sc.nextLine();
        System.out.print("Category (1=Inpatient, 2=Outpatient, 3=Emergency): ");
        int ch = Integer.parseInt(sc.nextLine());
        PatientCategory cat;
        if (ch == 2) { cat = PatientCategory.Outpatient; }
        else if (ch == 3) { cat = PatientCategory.Emergency; }
        else { cat = PatientCategory.Inpatient; }
        Patient p;
        if (cat == PatientCategory.Inpatient) {
            System.out.print("Ward Number: "); String ward = sc.nextLine();
            System.out.print("Admission Date: "); String date = sc.nextLine();
            p = new Inpatient(id, fn, ln, age, gender, cond, ward, date);
        } else {
            p = new Patient(id, fn, ln, age, gender, cond, cat);
        }
        patients.add(p);
        System.out.println("Patient registered!");
    }

    public void searchPatient(){ System.out.print("Enter ID: "); Patient p=findPatientById(sc.nextLine()); System.out.println(p!=null? p : "Not found"); }
    public void updatePatient(){ System.out.print("Enter ID to update: "); Patient p=findPatientById(sc.nextLine()); if(p==null){ System.out.println("Not found"); return; } System.out.print("New First Name: "); p.setFirstName(sc.nextLine()); System.out.print("New Last Name: "); p.setLastName(sc.nextLine()); System.out.print("New Age: "); p.setAge(Integer.parseInt(sc.nextLine())); System.out.print("New Condition: "); p.setMedicalCondition(sc.nextLine()); System.out.println("Updated!"); }
    public void deletePatient(){ System.out.print("Enter ID to delete: "); Patient p=findPatientById(sc.nextLine()); if(p!=null){ patients.remove(p); System.out.println("Deleted!"); } else System.out.println("Not found"); }
    public void displayAll(){ if(patients.isEmpty()){ System.out.println("No patients"); return; } for(Patient p: patients) System.out.println(p); }
    public int getTotalPatients(){ return patients.size(); }
    public Patient getPatientById(String id){ return findPatientById(id); }
    private Patient findPatientById(String id){ for(Patient p: patients) if(p.getPatientID().equalsIgnoreCase(id)) return p; return null; }
}
    

