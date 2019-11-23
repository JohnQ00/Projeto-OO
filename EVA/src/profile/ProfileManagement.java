package profile;

import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

import classes.ClassesManagement;

public class ProfileManagement {
    public Scanner entry = new Scanner(System.in);
    ClassesManagement ClassesM = new ClassesManagement();
    public void accountOptions(int choice, User user, ArrayList<User> users){
        if (choice == 1){
            System.out.println("Do you want to create a professor or a student account ?\n[1 to Professor]\n[2 to Student]");
            System.out.print("Type here: ");
            int accountDecision = entry.nextInt();
            if(accountDecision == 1)
            {
                user = new Professor();
            }
            else
                user = new Student();

            System.out.print("CPF: ");
            user.setCpf(entry.next());
            System.out.print("Username: ");
            user.setUsername(entry.next());
            System.out.print("Password: ");
            user.setPassword(entry.next());
            System.out.println();
            users.add(user);

            System.out.println("You succesfully created an account.");
        }
        if (choice == 2){
            System.out.print("CPF: ");
            String cpf = entry.next();
            System.out.print("Password: ");
            String password = entry.next();

            int userId = searchUsers(cpf,password,user,users);
            System.out.println("Id " + userId);
            if (userId == -1) { return; }
            System.out.println("\nUsername: "+ users.get(userId).getUsername());
            if (users.get(userId) instanceof Student)
                System.out.println("You are a student.");
            else
                System.out.println("You are a professor.");
            loggedDecision(userId,user,users);
            return;
        }

    }

    public int searchUsers(String cpf, String password, User user, ArrayList<User> users){

        for (int i = 0; i < users.size(); i++) {
            //printar(users);
            if(users.get(i) != null) {
                if (users.get(i).getCpf().equalsIgnoreCase("admin") && users.get(i).getPassword().equalsIgnoreCase("admin")) {
                    System.out.println("\nLogged as administrator.\n");
                }
                if (users.get(i).getCpf().equalsIgnoreCase(cpf) && users.get(i).getPassword().equalsIgnoreCase(password)) {
                    System.out.println("\nLogin was done. ");
                    return i;
                }
            }
        }
        System.out.println("\nLogin was not done.\n");
        return -1;
    }

    public void printar(ArrayList<User> u){
        System.out.println(u.size());
        for (User c: u){
            if(c != null)
                System.out.println(c.getCpf());
        }
    }

    public void loggedOptions(int userId, ArrayList<User> users){
        System.out.println("As a logged user,what you want to do ?");
        System.out.println("0 to Logout");
        System.out.println("1 to Create a profile");
        System.out.println("2 to Edit your profile");
        System.out.println("3 to Check your profile");
        if (users.get(userId) instanceof Professor) {
            System.out.println("4 to Create a class");
            System.out.println("5 to Add students");
        }
        if (users.get(userId) instanceof Student) {
            System.out.println("4 to Enter a class");
        }
    }

    public void loggedDecision(int userId, User user,ArrayList<User> users){
        while(true) {
            loggedOptions(userId, users);
            System.out.println();
            System.out.print("Type here: ");
            int decision = entry.nextInt();
            if (decision == 0) {return;}
            else if (decision == 1) { profileCreation(userId, user, users);}
            else if (decision == 2) { profileChange(userId, user, users);}
            else if (decision == 3) { profileCheck(userId, user, users);}
            if (users.get(userId) instanceof Professor) {
                if (decision == 4) {
                    ClassesM.classManagement(userId, users);
                }
                if (decision == 5) {
                    ClassesM.addStudents(userId, users);
                }
            }
            else if (users.get(userId) instanceof Student){
                if (decision == 4){
                    ClassesM.enterInClass(userId, users);
                }
            }
        }
    }

    public void profileCreation(int userId, User user,ArrayList<User> users) { // criar perfi do studante
        System.out.print("Insert your full name: ");
        entry.nextLine();
        users.get(userId).setFullName(entry.nextLine());
        System.out.print("Insert your age: ");
        users.get(userId).setAge(entry.nextInt());
        System.out.print("Insert your e-mail: ");
        users.get(userId).setEmail(entry.next());
        if (users.get(userId) instanceof Professor) {
            System.out.print("Insert your number of classes: ");
            ((Professor) users.get(userId)).setClassesQuantity(entry.nextInt());
            entry.nextLine();
            System.out.print("Insert your formation: ");
            ((Professor) users.get(userId)).setFormation(entry.nextLine());
            System.out.print("Insert your specialization: ");
            ((Professor) users.get(userId)).setSpecialization(entry.nextLine());
        }
        else{
            System.out.print("Insert your registration number: ");
            ((Student) users.get(userId)).setRegistrationNumber(entry.nextInt());
            entry.nextLine();
            System.out.print("Insert your University course: ");
            ((Student) users.get(userId)).setUniversityDiscipline(entry.nextLine());
            System.out.print("Insert your Course period: ");
            ((Student) users.get(userId)).setUniversityPeriod(entry.nextInt());
            System.out.print("Insert your ingression year: ");
            ((Student) users.get(userId)).setIngressionYear(entry.nextInt());
            System.out.println();
        }

        return;
    }

    public void profileCheck(int userId, User user, ArrayList<User> users){
        System.out.println("Do you want to see your informations ? [Yes / No]");
        String decision = entry.next();
        if (decision.equalsIgnoreCase("Yes")){

            System.out.print("\nFull name: ");
            System.out.println(users.get(userId).getFullName());
            System.out.print("Age: ");
            System.out.println(users.get(userId).getAge());
            System.out.print("E-mail: ");
            System.out.println(users.get(userId).getEmail());

            if (users.get(userId) instanceof Student) {
                System.out.print("Registration number: ");
                System.out.println((((Student) users.get(userId))).getRegistrationNumber());
                System.out.print("Ingression year: ");
                System.out.println((((Student) users.get(userId))).getIngressionYear());
                System.out.print("University course: ");
                System.out.println((((Student) users.get(userId))).getUniversityDiscipline());
                System.out.print("University period: ");
                System.out.println((((Student) users.get(userId))).getUniversityPeriod());
                System.out.println();
            }
            else{
                System.out.print("Number of classes: ");
                System.out.println(((Professor) users.get(userId)).getClassesQuantity());
                System.out.print("Formation: ");
                System.out.println(((Professor) users.get(userId)).getFormation());
                System.out.print("Insert your specialization: ");
                System.out.println(((Professor) users.get(userId)).getSpecialization());
                System.out.println();
            }
        }
        else{
            return;
        }
    }

    public void profileChange(int userId, User user, ArrayList<User> users){
        profileChangeInfo();
        if (users.get(userId) instanceof Student) { System.out.println("5 to Registration number"); }
        else { professionProfileChangeInfo(); }

        System.out.print("Type here: ");
        int decision = entry.nextInt();

        System.out.print("Type here: ");
        if (decision == 0){return; }
        if (decision == 1){ entry.nextLine(); users.get(userId).setFullName(entry.nextLine()); }
        else if (decision == 2){ users.get(userId).setAge(entry.nextInt()); }
        else if (decision == 3){ users.get(userId).setEmail(entry.next()); }
        else if (decision == 4){ entry.nextLine(); users.get(userId).setUsername(entry.nextLine());}

        if (users.get(userId) instanceof Student)
            if (decision == 5){ ((Student) users.get(userId)).setRegistrationNumber(entry.nextInt());}
        if (users.get(userId) instanceof Professor){
            if (decision == 5){ ((Professor) users.get(userId)).setClassesQuantity(entry.nextInt()); }
            else if (decision == 6){ entry.nextLine(); ((Professor) users.get(userId)).setFormation(entry.nextLine()); }
            else if (decision == 7) ((Professor) users.get(userId)).setSpecialization(entry.nextLine());
        }
        System.out.println();
    }

    public void profileChangeInfo(){
        System.out.println("What information do you want to change ?");
        System.out.println("0 to None");
        System.out.println("1 to Full name");
        System.out.println("2 to Age");
        System.out.println("3 to E-mail");
        System.out.println("4 to Username");
    }

    public void professionProfileChangeInfo(){
        System.out.println("5 to Number of classes");
        System.out.println("6 to Formation");
        System.out.println("7 to Specialization");
    }
}
