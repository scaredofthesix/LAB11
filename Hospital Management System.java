import java.util.Scanner;

class Bill {
    int id;
    String name;
    double amount;

    Bill(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}

class Patient {
    int id;
    String name;
    Bill bill;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Doctor {
    int id;
    String name;

    Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void checkPatient(Patient patient) {
    }
}

class Receptionlist {
    int id;
    String name;

    Receptionlist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void generateBill(Patient patient, String billName, double amount) {
        patient.bill = new Bill(patient.id, billName, amount);
    }
}

public class LAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Patient[] patients = new Patient[10];
        patients[0] = new Patient(1, "patient 1");
        patients[1] = new Patient(2, "patient 2");
        patients[2] = new Patient(3, "patient 3");
        patients[3] = new Patient(4, "patient 4");
        patients[4] = new Patient(5, "patient 5");
        Doctor doctor = new Doctor(1, "doctor 1");
        Receptionlist receptionist = new Receptionlist(1, "receptionlist 1");
        receptionist.generateBill(patients[4], "medical bill", 100.0);

        while (true) {
            System.out.println("1 - doctor");
            System.out.println("2 - patient");
            System.out.println("3 - exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("enter patient ID 1 - 5:");
                int patientId = scanner.nextInt();
                if (patientId >= 1 && patientId <= 5) {
                    doctor.checkPatient(patients[patientId-1]);
                }
            }
            else if (choice == 2) {
                System.out.println("enter your patient ID 1 - 5");
                int patientId = scanner.nextInt();
                if (patientId >= 1 && patientId <= 5) {
                    Patient p = patients[patientId-1];
                    if (p.bill != null) {
                        p.bill = null;
                    }
                }
            }
            else if (choice == 3) {
                break;
            }
        }
        scanner.close();
    }
}
