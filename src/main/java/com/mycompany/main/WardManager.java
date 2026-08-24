/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;


/**
 *
 * @author Emmertia
 */
public class WardManager {
    
    private Bed[][] ward = new Bed[4][5];
    private PatientManagement patientManager;
    private Scanner sc = new Scanner(System.in);

    public WardManager(PatientManagement pm){
        this.patientManager = pm;
        int c=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                ward[i][j]=new Bed(String.format("B%02d", c++));
            }
        }
    }

    public void allocateBed(){
        System.out.print("Enter Inpatient ID: "); String id=sc.nextLine();
        Patient p=patientManager.getPatientById(id);
        if(p==null){ System.out.println("Not found"); return; }
        if(p.getPatientCategory()!=PatientCategory.Inpatient){ System.out.println("Only Inpatients can get a bed!"); return; }
        if(p.getAllocatedBed()!=null){ System.out.println("Already has bed: "+p.getAllocatedBed()); return; }
        for(int i=0;i<4;i++) for(int j=0;j<5;j++) if(ward[i][j].isAvailable()){
            ward[i][j].allocate(p); p.setAllocatedBed(ward[i][j].getBedId());
            System.out.println("Bed "+ward[i][j].getBedId()+" allocated"); return;
        }
        System.out.println("No beds available!");
    }

    public void releaseBed(){ System.out.print("Enter ID to discharge: "); String id=sc.nextLine(); Patient p=patientManager.getPatientById(id); if(p==null||p.getAllocatedBed()==null){ System.out.println("No bed found"); return; } for(int i=0;i<4;i++) for(int j=0;j<5;j++) if(ward[i][j].getBedId().equals(p.getAllocatedBed())){ ward[i][j].release(); p.setAllocatedBed(null); System.out.println("Bed released"); return; } }
    public void displayWardLayout(){ System.out.println("\n--- WARD LAYOUT 4x5 ---"); for(int i=0;i<4;i++){ for(int j=0;j<5;j++){ Bed b=ward[i][j]; System.out.print(b.isAvailable()? b.getBedId()+"[Empty]\t" : b.getBedId()+"["+b.getPatient().getPatientID()+"]\t"); } System.out.println(); } }
    public void displayAvailableBeds(){ System.out.print("Available: "); for(int i=0;i<4;i++) for(int j=0;j<5;j++) if(ward[i][j].isAvailable()) System.out.print(ward[i][j].getBedId()+" "); System.out.println(); }
    public void displayOccupiedBeds(){ System.out.println("Occupied:"); for(int i=0;i<4;i++) for(int j=0;j<5;j++) if(!ward[i][j].isAvailable()) System.out.println(ward[i][j].getBedId()+" -> "+ward[i][j].getPatient().getPatientID()); }
    public int getTotalOccupied(){ int c=0; for(int i=0;i<4;i++) for(int j=0;j<5;j++) if(!ward[i][j].isAvailable()) c++; return c; }
}
    

