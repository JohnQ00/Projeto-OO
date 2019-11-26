package exercises;

import professor.Professor;
import user.User;

import java.util.ArrayList;

public class ReportCardManagement {

    public void checkingReportCard(int userId, ArrayList<User> users){
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++) {
                for (int k = 0; k < 500; k++){
                    if(((Professor) users.get(i)).classes[i][j] != null){
                        if (users.get(userId).getUsername().equals(((Professor) users.get(i)).classes[i][j].classUsers[k])){
                            System.out.println("Classes: ");
                            System.out.println(((Professor) users.get(i)).classes[i][j].course);
                            float meanCalculus = printingGrades(userId, users, i, j);
                            if (meanCalculus >= 7.00000){
                                boolean attendanceApproval = checkAttendance(userId, users, i, j);
                                if (attendanceApproval) {
                                    System.out.println("\nYour final grade is: " + meanCalculus);
                                    System.out.println(users.get(userId).getUsername() + " was approved.\n");
                                }
                                else {
                                    System.out.println("\nYour final grade is: " + meanCalculus);
                                    System.out.println(users.get(userId).getUsername() + " was not approved.\n");
                                }
                            }
                            else{
                                System.out.println("\nYour final grade is: " + meanCalculus);
                                System.out.println(users.get(userId).getUsername() + " was not approved.\n");
                            }
                        }
                    }
                }
                break;
            }
            break;
        }
    }

    private boolean checkAttendance(int userId, ArrayList<User> users, int professorId, int classId) {
        int attendanceCounterA = 0;
        int attendanceCounterB = 0;
        int i;
        for (i = 0; i < 500; i++){
            if (((Professor) users.get(professorId)).classes[professorId][classId].attendances[i] != null) {
                if (users.get(userId).getUsername().equals(((Professor) users.get(professorId)).classes[professorId][classId].attendances[i].inStudents[i])) {
                    attendanceCounterA++;
                }
                if (users.get(userId).getUsername().equals(((Professor) users.get(professorId)).classes[professorId][classId].attendances[i].outStudents[i])) {
                    attendanceCounterB++;
                }
            }
            else
                break;
        }
        int baseCounter = ((Professor) users.get(professorId)).classes[professorId][classId].attendances[classId].attendanceNumber;
        if ((attendanceCounterA/baseCounter) > 0.25){
            return true;
        }
        return false;
    }

    private float printingGrades(int userId, ArrayList<User> users, int professorId, int classId) {
        float mean = 0;
        for (int i = 0; i < 500; i++) {
            for (int j = 1; j <= 4; j++) {
                if (((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j] >= 0) {
                    System.out.println("AV" + (j));
                    System.out.println("Grade: " + ((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j]);
                    mean += ((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j];
                }
            }
            return (mean/4);
        }
        return -1;
    }
}
