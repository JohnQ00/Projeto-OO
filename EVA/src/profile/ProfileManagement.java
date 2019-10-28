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
            //counter++;

            System.out.println("You succesfully created an account.");
        }
        if (choice == 3){
            System.out.print("CPF: ");
            String cpf = entry.next();
            System.out.print("Password: ");
            String password = entry.next();

            int studentId = searchUsers(cpf,password,s,users);

            loggedOptions();
            System.out.println();
            loggedDecision(studentId,s,users);
            return;
        }

    }

    public static int searchUsers(String cpf, String password, Student s, ArrayList<User> users){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof User) {
                if (users.get(i).getCpf().equalsIgnoreCase(cpf) && users.get(i).getPassword().equalsIgnoreCase(password)) {
                    System.out.println("\nLogin was done.\n");
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
        System.out.println("0  to Logout");
        System.out.println("1 to Create a profile");
        System.out.println("2 to Edit your profile");
    }

    public static void loggedDecision(int studentId, Student s,ArrayList<User> users){
        System.out.print("Type here: ");
        int decision = entry.nextInt();
        if (decision == 1){
            profileCreation(studentId,s,users);
        }
        return;
    }

    public static void profileCreation(int studentId, Student s,ArrayList<User> users){
//        System.out.println("Insert your full name:");
//        s.getFullName(entry.nextLine());
//        entry.nextLine();
//        System.out.println("Insert your e-mail:");
//        s.getEmail(entry.next());
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

        users.add(studentId,s);

        System.out.println(s.getRegistrationNumber());
        System.out.println(s.getUniversityCourse());
        System.out.println(s.getUniversityPeriod());
        System.out.println(s.getIngressionYear());
        System.out.println();

    }
}
