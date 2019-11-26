package classes;

import java.util.ArrayList;
import java.util.Scanner;

import exercises.ExercisesManagement;
import professor.Professor;
import profile.Attendance;
import time.TimeCounter;
import user.User;

public class AttendanceManagement {
    ExercisesManagement checkingClass = new ExercisesManagement();
    TimeCounter attendanceDayAndMonth = new TimeCounter();
    Scanner entry = new Scanner(System.in);
    
    public void MakingTheAttendance(int userId, ArrayList<User> users, int day, int month){
        Attendance attendance = new Attendance();

        System.out.println("Showing your classes: ");
        checkingClass.printingClasses(userId, users);
        System.out.print("Select a class: ");
        String classC = entry.next();
        int classId = checkingClass.selectingClass(userId, users, classC);
        for (int i = 0; i < 500; i++){
            if (((Professor) users.get(userId)).classes[userId][classId].attendances[i] == null){
                ((Professor) users.get(userId)).classes[userId][classId].attendances[i] = attendance;
                ((Professor) users.get(userId)).classes[userId][classId].attendances[i].day = day;
                ((Professor) users.get(userId)).classes[userId][classId].attendances[i].month = month;
                break;
            }
        }
        selectingStudents(userId, users, classId);
        System.out.println("The attendace was finished.\n");
    }

    private void selectingStudents(int userId, ArrayList<User> users, int classId) {
        System.out.println("The students of " + ((Professor) users.get(userId)).classes[userId][classId].course + " class: ");
        for (int i = 0; i < 500; i++) {
            for (int m = 0; m < 500; m++) {
                if (((Professor) users.get(userId)).classes[userId][i].classUsers[m] != null) {
                    System.out.println("Student [" + ((Professor) users.get(userId)).classes[userId][i].classUsers[m]+"]");
                    attendanceStudent(userId, users, classId, i);
                }
            }
            break;
        }
    }

    private void attendanceStudent(int userId, ArrayList<User> users, int classId, int attendanceId) {
        System.out.println("Mark if the student is on the class: ");
        String inOrOut = entry.next();
        if (inOrOut.equalsIgnoreCase("Yes")){
            ((Professor) users.get(userId)).classes[userId][classId].attendances[attendanceId].inStudents[attendanceId] = users.get(attendanceId).getUsername();
        }
        else{
            ((Professor) users.get(userId)).classes[userId][classId].attendances[attendanceId].outStudents[attendanceId] = users.get(attendanceId).getUsername();
        }
    }

}
