package classes;

import exceptions.ExceptionManagement;
import professor.Professor;
import student.Student;
import user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassesManagement {
    //Tenta arrumar uma solução para o entry.nextLine()
    public Scanner entry = new Scanner(System.in);
    private Classes classes = new Classes();
    ExceptionManagement Exceptions = new ExceptionManagement();
    public void classManagement(int userId, ArrayList<User> users){
        classes = new Classes();
        System.out.print("Insert the name of discipline you teach: ");
        classes.setCourse(entry.nextLine());
        classes.setVacancies(Exceptions.scanInt("Insert the number of vacancies you want to dispose: "));
        classes.setCreator(users.get(userId).getUsername());
        for(int i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).getClasses()[userId][i] == null) {
                ((Professor) users.get(userId)).getClasses()[userId][i] = classes;
                break;
            }
        }
        System.out.println("Your class was successfully created.\n");
    }

    public void addStudents(int userId, ArrayList<User> users){
        System.out.println("Which course do you want to add students ? ");
        System.out.println("Here's the list of your disciplines: ");
        for(int i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).getClasses()[userId][i] != null) {
                System.out.println(((Professor) users.get(userId)).getClasses()[userId][i].getCourse());
            }
        }
        System.out.print("Type here: ");
        String classSelected = entry.next();
        for(int i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).getClasses()[userId][i] != null) {
                if (classSelected.equalsIgnoreCase(((Professor) users.get(userId)).getClasses()[userId][i].getCourse())) {
                    if (((Professor) users.get(userId)).getClasses()[userId][i].getVacancies() == 0){
                        System.out.println("There's no vacancies in this class.");
                        break;
                    }
                    System.out.print("Type here the name of the student you want to add: ");
                    String searchingStudent = entry.next();

                    for (int j = 0; j < 500; j++) {
                        if (searchingStudent.equals(((Professor) users.get(userId)).getClasses()[userId][i].getClassUsers()[j])){
                            System.out.println("The student is already in this class.\n");
                            break;
                        }
                        if (searchingStudent.equalsIgnoreCase(users.get(j).getUsername())) {
                            for (int k = 0; k < 500; k++) {
                                if (((Student) users.get(j)).getCoursesIn()[k] == null) {
                                    ((Student) users.get(j)).getCoursesIn()[k] = classSelected;
                                    ((Professor) users.get(userId)).getClasses()[userId][i].setClassUsers(searchingStudent);
                                    ((Professor) users.get(userId)).getClasses()[userId][i].setVacancies(((Professor) users.get(userId)).getClasses()[userId][i].getVacancies() - 1);
                                    System.out.println("The student was sucessfully added.\n");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                else{
                    System.out.println("The class was not found or doesn't exist.");
                    break;
                }
            }
        }
    }

    public void enterInClass(int userId, ArrayList<User> users){
        System.out.print("Type the name of the class you want to enter: ");
        String classChose = entry.next();

        for(int i=0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                if (classChose.equals(((Professor) users.get(i)).getClasses()[i][j].getCourse())) {
                    if (users.get(userId).getUsername().equals(((Professor) users.get(i)).getClasses()[i][j].getClassUsers()[j])){
                        System.out.println("You are already in this class.");
                        break;
                    }
                    if (((Professor) users.get(i)).getClasses()[i][j].getVacancies() == 0) {
                        System.out.println("There's no vacancies in this class.");
                        break;
                    }
                    System.out.println("The class has been founded.\n");
                    System.out.println("Do you want to enter in this class?");
                    System.out.println("0 to No\n1 to Yes\n");
                    int decision = Exceptions.scanInt("Type here: ");
                    if (decision == 0){break;}
                    if (decision == 1) {
                        for (int l = 0; l < 500; l++)
                            if (((Student) users.get(userId)).getCoursesIn()[l] == null){
                                ((Student) users.get(userId)).getCoursesIn()[l] = ((Professor) users.get(i)).getClasses()[i][j].getCourse();
                                ((Professor) users.get(i)).getClasses()[i][j].getClassUsers()[j] = ((Student) users.get(userId)).getUsername();
                                ((Professor) users.get(i)).getClasses()[i][j].setVacancies(((Professor) users.get(i)).getClasses()[i][j].getVacancies() - 1);
                                System.out.println("You succesfully entered in " + ((Professor) users.get(i)).getClasses()[i][j].getCourse() + " class.\n");
                                break;
                            }
                    }
                }
                break;
            }
            break;
        }
    }
}
