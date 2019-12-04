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
        String classC = entry.nextLine();
        int classId = checkingClass.selectingClass(userId, users, classC);
        if (classId < 0 || classId >= 500){return;}
        for (int i = 0; i < 500; i++){
            if (((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[i] == null){
                ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[i] = attendance;
                ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[i].setDay(day);
                ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[i].setMonth(month);
                break;
            }
        }
        selectingStudents(userId, users, classId);
        System.out.println("The attendace was finished.\n");
    }

    private void selectingStudents(int userId, ArrayList<User> users, int classId) {
        System.out.println("The students of " + ((Professor) users.get(userId)).getClasses()[userId][classId].getCourse() + " class: ");
        for (int i = 0; i < 500; i++) {
            for (int m = 0; m < 500; m++) {
                if (((Professor) users.get(userId)).getClasses()[userId][i].getClassUsers()[m] != null) {
                    System.out.println("Student [" + ((Professor) users.get(userId)).getClasses()[userId][i].getClassUsers()[m]+"]");
                    attendanceStudent(userId, users, classId, i);
                }
            }
            break;
        }
    }

    private void attendanceStudent(int userId, ArrayList<User> users, int classId, int attendanceId) {
        System.out.println("Mark if the student is on the class: ");
        String inOrOut = entry.next();
        ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[attendanceId].setAttendanceNumber(+1);
        if (inOrOut.equalsIgnoreCase("Yes")){
            ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[attendanceId].setInStudents(users.get(attendanceId).getUsername());
            ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[attendanceId].setOutStudents("null");
        }
        else{
            ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[attendanceId].setInStudents("null");
            ((Professor) users.get(userId)).getClasses()[userId][classId].getAttendances()[attendanceId].setOutStudents(users.get(attendanceId).getUsername());
        }
    }

}
