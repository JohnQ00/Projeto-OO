package profile;

import classes.AttendanceManagement;
import exceptions.ExceptionManagement;
import exercises.ReportCardManagement;
import professor.Professor;
import student.MonitorManagement;
import student.Student;
import time.TimeCounter;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

import classes.ClassesManagement;
import messages.Messages;
import exercises.ExercisesManagement;

public class ProfileManagement {

    public Scanner entry = new Scanner(System.in);
    ClassesManagement ClassesM = new ClassesManagement();
    Messages SendingMessage = new Messages();
    ExercisesManagement Exercises = new ExercisesManagement();
    MonitorManagement Monitor = new MonitorManagement();
    AttendanceManagement Attendance = new AttendanceManagement();
    ReportCardManagement ReportCard = new ReportCardManagement();
    TimeCounter TimeC = new TimeCounter();
    ExceptionManagement Exceptions = new ExceptionManagement();

    public void accountOptions(int choice, User user, ArrayList<User> users){
        if (choice == 1){
            System.out.println("\nTo enter as a administrator just use 'admin' in all credentials.\n");
            System.out.println("Do you want to create a professor or a student account ?\n[1 to Professor]\n[2 to Student]");
            int accountDecision = Exceptions.scanInt("Type here: ");
            if(accountDecision == 1)
                user = new Professor();
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
            if (userId == -1) { return; }
            System.out.println("Username: "+ users.get(userId).getUsername());
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
                    return i;
                }
                if (users.get(i).getCpf().equals(cpf) && users.get(i).getPassword().equals(password)) {
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
        if (users.get(userId).getCpf().equalsIgnoreCase("admin") && users.get(userId).getPassword().equalsIgnoreCase("admin")){
            while(true) {
                System.out.println("Exit the time management ?");
                System.out.println("Type: ");
                String exit = entry.next();
                if (exit.equalsIgnoreCase("Yes")){break;}

                System.out.println("Do you want to see the date ?");
                System.out.print("Type: ");
                String decisionTime = entry.next();
                if (decisionTime.equalsIgnoreCase("Yes")) {
                    TimeC.getDate();
                }

                System.out.println("Do you want to pass the day ?");
                System.out.print("Type: ");
                String decisionTime0 = entry.next();
                if (decisionTime0.equalsIgnoreCase("Yes")){
                    TimeC.passDay();
                }
            }
        }
        else {
            TimeC.getDate();
            System.out.println("\nAs a logged user,what you want to do ?");
            System.out.println("0 to Logout");
            System.out.println("1 to Create a profile");
            System.out.println("2 to Edit your profile");
            System.out.println("3 to Check your profile");
            if (users.get(userId) instanceof Professor) {
                System.out.println("4 to Create a class");
                System.out.println("5 to Add students");
                System.out.println("6 to Send a message");
                System.out.println("7 to Check your message box");
                System.out.println("8 to Create a lesson");
                System.out.println("9 to Create a test");
                System.out.println("10 to Turn a student in a monitor");
                System.out.println("11 to Make the attendance");
            }
            if (users.get(userId) instanceof Student) {
                System.out.println("4 to Enter a class");
                System.out.println("5 to Send a message");
                System.out.println("6 to Check your message box");
                System.out.println("7 to Answer a lesson");
                System.out.println("8 to Answer a test");
                System.out.println("9 to See the report card");
                if (((Student) users.get(userId)).monitor == true) {
                    System.out.println("10 to Create a lesson");
                }
            }
        }

    }

    public void loggedDecision(int userId, User user,ArrayList<User> users){
        while(true) {
            loggedOptions(userId, users);
            System.out.println();
            int decision = Exceptions.scanInt("Type here: ");
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
                if (decision == 6){
                    SendingMessage.sendingMessages(userId, users);
                }
                if (decision == 7){
                    SendingMessage.checkMessageBox(userId, users);
                }
                if (decision == 8){
                    Exercises.lessonCreation(userId, users);
                }
                if (decision == 9){
                    Exercises.testCreation(userId, users);
                }
                if (decision == 10){
                    Monitor.turnIntoMonitor(userId, users);
                }
                if (decision == 11){
                    int actualDay = TimeC.getDay();
                    int actualMonth = TimeC.getMonth() + 1;
                    Attendance.MakingTheAttendance(userId, users, actualDay, actualMonth);
                }
            }
            else if (users.get(userId) instanceof Student){
                if (((Student) users.get(userId)).monitor == true){
                    if (decision == 10){
                        int userIdP = Exercises.returningProfessorId(userId, users);
                        Exercises.lessonCreation(userIdP, users);
                    }
                }
                if (decision == 4){
                    ClassesM.enterInClass(userId, users);
                }
                if (decision == 5){
                    SendingMessage.sendingMessages(userId, users);
                }
                if (decision == 6){
                    SendingMessage.checkMessageBox(userId, users);
                }
                if (decision == 7){
                    Exercises.checkingLessonsAndTests(userId, users, decision);
                }
                if (decision == 8){
                    Exercises.checkingLessonsAndTests(userId, users, decision);
                }
                if (decision == 9){
                    ReportCard.checkingReportCard(userId, users);
                }
            }
        }
    }

    public void profileCreation(int userId, User user,ArrayList<User> users) { // criar perfil do estudante
        System.out.print("Insert your full name: ");
        entry.nextLine();
        users.get(userId).setFullName(entry.nextLine());//
        users.get(userId).setAge(Exceptions.scanInt("Insert your age: "));//
        System.out.print("Insert your e-mail: ");
        users.get(userId).setEmail(entry.next());//
        if (users.get(userId) instanceof Professor) {
            ((Professor) users.get(userId)).setClassesQuantity(Exceptions.scanInt("Insert your number of classes: "));
            entry.nextLine();
            System.out.print("Insert your formation: ");
            ((Professor) users.get(userId)).setFormation(entry.nextLine());
            System.out.print("Insert your specialization area: ");
            ((Professor) users.get(userId)).setSpecialization(entry.nextLine());
        }
        else{
            ((Student) users.get(userId)).setRegistrationNumber(Exceptions.scanInt("Insert your registration number: "));
            entry.nextLine();
            System.out.print("Insert your University course: ");
            ((Student) users.get(userId)).setUniversityDiscipline(entry.nextLine());
            ((Student) users.get(userId)).setUniversityPeriod(Exceptions.scanInt("Insert your Course period: "));
            ((Student) users.get(userId)).setIngressionYear(Exceptions.scanInt("Insert your ingression year: "));
            System.out.println();
        }

        return;
    }

    public void profileCheck(int userId, User user, ArrayList<User> users){
        System.out.println("Do you want to see your informations ? [Yes / No]");
        String decision = entry.next();
        if (decision.equalsIgnoreCase("Yes")){

            System.out.print("\nFull name: ");
            System.out.println(users.get(userId).getFullName());//
            System.out.print("Age: ");
            System.out.println(users.get(userId).getAge());//
            System.out.print("E-mail: ");
            System.out.println(users.get(userId).getEmail());//

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

        int decision = Exceptions.scanInt("Type here: ");

        System.out.print("Type here: ");
        if (decision == 0){return; }
        if (decision == 1){ entry.nextLine(); users.get(userId).setFullName(entry.nextLine()); }//
        else if (decision == 2){ users.get(userId).setAge(Exceptions.scanInt("Type here: ")); }//
        else if (decision == 3){ users.get(userId).setEmail(entry.next()); }//
        else if (decision == 4){ entry.nextLine(); users.get(userId).setUsername(entry.nextLine());}//

        if (users.get(userId) instanceof Student)
            if (decision == 5){ ((Student) users.get(userId)).setRegistrationNumber(Exceptions.scanInt("Type here: "));}
        if (users.get(userId) instanceof Professor){
            if (decision == 5){ ((Professor) users.get(userId)).setClassesQuantity(Exceptions.scanInt("Type here: ")); }
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
