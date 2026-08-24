/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.Scanner;


/**
 *
 * @author Emmertia
 */


public class Main {
    public static void main(String[] args) {
        PatientManagement patientManager = new PatientManagement();
        WardManager wardManager = new WardManager(patientManager);
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            //PATIENT MANAGEMNT
            System.out.println("\nHOSPITAL SYSTEM");
            System.out.println("1.Register");
                System.out.println (" 2.Search") ;
                System.out.println (" 3.Update");
                System.out.println ("4.Delete");
                System.out.println ("5.Display All");
                // BED MANGEMENT
            System.out.println("6.Allocate Bed");
                System.out.println(" 7.Release Bed ");
            System.out.println ("8.Ward Layout ");
                System.out.println ("9.Available ");
                System.out.println ("10.Occupied ");
                System.out.println ("11.REPORTS ");
                
            System.out.print("Enter Choice: ");
            try{ choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=-1; }

            if (choice == 1) { patientManager.registerPatient(); }
            else if (choice == 2) { patientManager.searchPatient(); }
            else if (choice == 3) { patientManager.updatePatient(); }
            else if (choice == 4) { patientManager.deletePatient(); }
            else if (choice == 5) { patientManager.displayAll(); }
            else if (choice == 6) { wardManager.allocateBed(); }
            else if (choice == 7) { wardManager.releaseBed(); }
            else if (choice == 8) { wardManager.displayWardLayout(); }
            else if (choice == 9) { wardManager.displayAvailableBeds(); }
            else if (choice == 10) { wardManager.displayOccupiedBeds(); }
            else if (choice == 11) {
                System.out.println("\nREPORTS ");
                patientManager.displayAll();
                wardManager.displayAvailableBeds();
                wardManager.displayOccupiedBeds();
                int total = patientManager.getTotalPatients();
                int occ = wardManager.getTotalOccupied();
                double perc = (occ/20.0)*100;
                System.out.println("Total Patients: "+total);
                System.out.println("Occupied: "+occ+"/20 = "+perc+" percent");
            }
            else if (choice == 0) { System.out.println("Exiting..."); }
            else { System.out.println("Invalid choice!"); }
        }while(choice!=0);
    }
}

