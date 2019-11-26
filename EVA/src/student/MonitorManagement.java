package student;

import professor.Professor;
import user.User;
import exercises.ExercisesManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MonitorManagement {
    Scanner entry = new Scanner(System.in);
    ExercisesManagement ManagingMonitor = new ExercisesManagement();
    public void turnIntoMonitor(int userId, ArrayList<User> users){
        System.out.println("Showing all of your classes: ");
        printingClasses(userId, users);
        System.out.println("Choose a class:");
        String classC = entry.next();
        int classNumber = ManagingMonitor.selectingClass(userId, users, classC);
        printingStudents(userId, users, classNumber);
        System.out.print("Choose a student to become a monitor: ");
        String studentToMonitor = entry.next();
        int studentIndex = searchingStudent(userId, users, classNumber, studentToMonitor);
        ((Student) users.get(studentIndex)).monitor = true;
        ((Professor) users.get(userId)).classes[userId][classNumber].monitors[studentIndex] = studentIndex;
        System.out.println("Now "+ (users.get(studentIndex)).getUsername() + " is a monitor.\n");
    }

    private void printingClasses(int userId, ArrayList<User> users){
        for (int j = 0; j< 500; j++){
            if (((Professor) users.get(userId)).classes[userId][j] != null){
                System.out.println(((Professor) users.get(userId)).classes[userId][j].course);
            }
        }
    }

    public void printingStudents(int userId, ArrayList<User> users, int classN) {
        System.out.println("The students of " + ((Professor) users.get(userId)).classes[userId][classN].course + " class: ");
        for (int i = 0; i < 500; i++) {
                for (int m = 0; m < 500; m++) {
                    if (((Professor) users.get(userId)).classes[userId][i].classUsers[m] != null) {
                        System.out.println(((Professor) users.get(userId)).classes[userId][i].classUsers[m]);
                    }
                }
                break;
        }
    }

    private int searchingStudent(int userId, ArrayList<User> users, int classN, String student){
        for (int i = 0; i < 500; i++) {
            if (((Professor) users.get(userId)).classes[userId][i] != null)
                for (int m = 0; m < 500; m++) {
                    if (student.equals(((Professor) users.get(userId)).classes[userId][i].classUsers[m])) {
                        System.out.println((((Professor) users.get(userId)).classes[userId][i].classUsers[m]) + " was found.");
                        return m;
                    }
                }
        }
        return -1;
    }
}
