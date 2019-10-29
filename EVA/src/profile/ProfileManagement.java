package profile;

import main.MainPage;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileManagement {
    public static Scanner entry = new Scanner(System.in);

    public static void accountOptions(int counter, int choice, Student s, ArrayList<User> users){
        s = new Student();
        if (choice == 1){
            System.out.print("CPF: ");
            s.setCpf(entry.next());
            System.out.print("Username: ");
            s.setUsername(entry.next());
            System.out.print("Password: ");
            s.setPassword(entry.next());

            users.add(s);

            System.out.println("You succesfully created an account.");
        }
        if (choice == 3){
            System.out.print("CPF: ");
            String cpf = entry.next();
            System.out.print("Password: ");
            String password = entry.next();

            int studentId = searchUsers(cpf,password,s,users);
            if (studentId == -1) { return; }
            System.out.println("\nUsername: "+ users.get(studentId).getUsername());
            loggedDecision(studentId,s,users);
            return;
        }

    }

    public static int searchUsers(String cpf, String password, Student s, ArrayList<User> users){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof User) {
                if (users.get(i).getCpf().equalsIgnoreCase(cpf) && users.get(i).getPassword().equalsIgnoreCase(password)) {
                    System.out.println("\nLogin was done.");
                    return i;
                }
                if (users.get(i).getCpf().equalsIgnoreCase("admin") && users.get(i).getPassword().equalsIgnoreCase("admin")) {
                    System.out.println("\nLogged as administrator.\n");
                }
                //printar(users);
            }
            else {
                System.out.println("\nLogin was not done.\n");
                return -1;
            }
        }
        return -1;
    }

    public static void printar(ArrayList<User> u){
        System.out.println(u.size());
        for (User c: u){
            System.out.println(c.getCpf());
        }
    }

    public static void loggedOptions(){
        System.out.println("As a logged user,what you want to do ?");
        System.out.println("0 to Logout");
        System.out.println("1 to Create a profile");
        System.out.println("2 to Edit your profile");
        System.out.println("3 to Check your profile");
    }

    public static void loggedDecision(int studentId, Student s,ArrayList<User> users){
        while(true) {
            loggedOptions();
            System.out.println();
            System.out.print("Type here: ");
            int decision = entry.nextInt();

            if (decision == 1) { profileCreation(studentId, s, users); }
            else if (decision == 2) { profileChange(studentId, s, users); }
            else if (decision == 3) { profileCheck(studentId, s, users);}
            else{
                return;
            }
        }
    }

    public static void profileCreation(int studentId, Student s,ArrayList<User> users) {
        System.out.print("Insert your full name: ");
        entry.nextLine();
        s.setFullName(entry.nextLine());
        System.out.print("Insert your age: ");
        s.setAge(entry.nextInt());
        System.out.print("Insert your e-mail: ");
        s.setEmail(entry.next());
        System.out.print("Insert your registration number: ");
        s.setRegistrationNumber(entry.nextInt());
        entry.nextLine();
        System.out.print("Insert your University course: ");
        s.setUniversityCourse(entry.nextLine());
        System.out.print("Insert your Course period: ");
        s.setUniversityPeriod(entry.nextInt());
        System.out.print("Insert your ingression year: ");
        s.setIngressionYear(entry.nextInt());
        System.out.println();

        users.add(studentId, s);
        return;
    }

    public static void profileCheck(int studentId, Student s, ArrayList<User> users){
        System.out.println("Do you want to see your informations ? [Yes / No]");

        String decision = entry.next();
        if (decision.equalsIgnoreCase("Yes")){

            System.out.print("\nFull name: ");
            System.out.println(s.getFullName());
            System.out.print("Age: ");
            System.out.println(s.getAge());
            System.out.print("E-mail: ");
            System.out.println(s.getEmail());

            if (users.get(studentId) instanceof Student) {
                System.out.print("Registration number: ");
                System.out.println((((Student) users.get(studentId))).getRegistrationNumber());
                System.out.print("Ingression year: ");
                System.out.println((((Student) users.get(studentId))).getIngressionYear());
                System.out.print("University course: ");
                System.out.println((((Student) users.get(studentId))).getUniversityCourse());
                System.out.print("University period: ");
                System.out.println((((Student) users.get(studentId))).getUniversityPeriod());
                System.out.println();
            }
        }
        else{
            return;
        }
    }

    public static void profileChange(int studentId, Student s, ArrayList<User> users){
        profileChangeInfo();
        System.out.print("Type here: ");
        int decision = entry.nextInt();
        System.out.print("Type here: ");
        if (decision == 0){return; }
        if (decision == 1){ entry.nextLine(); users.get(studentId).setFullName(entry.nextLine()); }
        else if (decision == 2){ users.get(studentId).setAge(entry.nextInt()); }
        else if (decision == 3){ users.get(studentId).setEmail(entry.next()); }
        else if (decision == 8) { entry.nextLine(); users.get(studentId).setUsername(entry.nextLine());}
        if (users.get(studentId) instanceof Student) {
            if (decision == 4) { ((Student) users.get(studentId)).setRegistrationNumber(entry.nextInt());}
            else if (decision == 5) { ((Student) users.get(studentId)).setIngressionYear(entry.nextInt()); }
            else if (decision == 6) { entry.nextLine(); ((Student) users.get(studentId)).setUniversityCourse(entry.nextLine()); }
            else if (decision == 7) { ((Student) users.get(studentId)).setUniversityPeriod(entry.nextInt()); }
        }
        System.out.println();
    }

    public static void profileChangeInfo(){
        System.out.println("What information do you want to change ?");
        System.out.println("0 to None");
        System.out.println("1 to Full name");
        System.out.println("2 to Age");
        System.out.println("3 to E-mail");
        System.out.println("4 to Registration number");
        System.out.println("5 to Ingression year");
        System.out.println("6 to University course");
        System.out.println("7 yo University period");
        System.out.println("8 to Username");
    }
}
