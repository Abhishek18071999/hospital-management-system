import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// patient class -> stores all the details about the patient
class PatientInfo{
    private String name;
    private int age;
    private String contactNo;
    private String address;
    private String medicalHistory;
    private String allergies;
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getContactNo() {
        return contactNo;
    }
    public String getAddress() {
        return address;
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public String getAllergies() {
        return allergies;
    }



    public PatientInfo(String name, int age, String contactNo , String address, String medicalhistory, String allergies){
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
        this.address = address;
        this.medicalHistory = medicalhistory;
        this.allergies = allergies;
    }
   
}
// Doctor class -> contains all the details about the doctor
class DoctorDetails{
    private String docName;
    private String specialization;
    public String getdocName(){
        return docName;
    }
    public String getspecialization(){
        return specialization;
    }
    public DoctorDetails(String docName, String specialization){
        this.docName = docName;
        this.specialization =specialization;
    }
}
public class HospitalMgmtSystem {
    private static List<PatientInfo> patients = new ArrayList<>();
    private static List<DoctorDetails> docDetails = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while(!exit){
            System.out.println("HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1.Enter the available doctors");
            System.out.println("2.Book an appointment");
            System.out.println("3.Veiw patient details");
            System.out.println("4.Veiw doctor details");
            System.out.println("5.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 : 
                    veiwAvailDoc(sc);
                    break;
                case 2:
                    bookAppointment();
                    break;
                case 3:
                    PatientInfo();
                    break;
                case 4:
                    doctorDetails();
                    break;
                case 5:
                    exit = true;
                    System.out.println("ThaNKyou for using Hospital management system");
                    break;
                default:
                    System.out.println("Please enter a valid number between 1 to 4");
                    break;
            }
            
        }
    }

    // book function is defined here
    private static void bookAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of patient : ");
            String name = sc.nextLine();
            System.out.print("Enter the age of patient : ");
            int age = sc.nextInt();
            System.out.print("Enter the contact number of patient : ");
            String contactNO = sc.nextLine();
            System.out.print("Enter the patient Adress : ");
            String address  = sc.nextLine();
            System.out.println("Enter the medical history. if any : type Yes/NO");
            String medicalHistory = sc.next();
            System.out.println("Is there any allergies in past : if any type YES/NO ");
            String allergies = sc.next();
            System.out.println("Available doctors : ");
            for(int i = 0;i<docDetails.size();i++){
                DoctorDetails doctor = docDetails.get(i);
                System.out.println((i+1)+" Doctor name : "+doctor.getdocName()+" specialization : "+doctor.getspecialization());
            }
            System.out.println("Choose the doctor you want appointment with : ");
            int docChoice = sc.nextInt();
            if(docChoice <1 || docChoice > docDetails.size()-1){
                System.out.println("invalid choice, booking not confirmed, please try again.....");
                return;
            }
            DoctorDetails selectDoc = docDetails.get(docChoice-1);
            PatientInfo p  = new PatientInfo(name, age, contactNO, address, medicalHistory, allergies);
            patients.add(p);
            System.out.println("Appointment is booked sucessfully");
         }
         // function for all the available doctors
         private static void veiwAvailDoc(Scanner sc){
            System.out.println("---------------------Hospital work------------------------");
            System.out.println("Enter the number of doctors available : ");
            int numDoc = sc.nextInt();
            for(int i = 0;i<numDoc;i++){
                System.out.println("Doctor : "+(i+1)+ ":");
                System.out.print("Enter the name : ");
                String name = sc.next();
                System.out.print("Enter the specialization : ");
                String specialization = sc.next();
                DoctorDetails dd = new DoctorDetails(name, specialization);
                docDetails.add(dd);
            }
        }
         // function which contains the patient information
         private static void PatientInfo(){
            if(patients.isEmpty()){
                System.out.println("No details found");
                return;
            }
            System.out.println("patients details : ");
            for(int i = 0;i<patients.size();i++){
                System.out.println("Patient "+(i+1)+" + ");
                PatientInfo patient = patients.get(i);
                System.out.println("Name : "+patient.getName());
                System.out.println("Age : "+patient.getAge());
                System.out.println("Address : "+patient.getAddress());
                System.out.println("Contact Number : "+patient.getContactNo());
                System.out.println("Allergies : "+patient.getAllergies());
                System.out.println("Medical history : "+patient.getMedicalHistory());
            }
        }
        private static void doctorDetails(){
            if(docDetails.isEmpty()){
                System.out.println("no records found");
                return;
            }
            System.out.println("The details pf doctors are : ");
            for(int i = 0;i<docDetails.size();i++){
                System.out.print("Doctor : "+(i+1)+" : ");
                DoctorDetails docDet = docDetails.get(i);
                System.out.println("Name : "+docDet.getdocName());
                System.out.println("Specialization : "+docDet.getspecialization());   
            }
            

        }
}
