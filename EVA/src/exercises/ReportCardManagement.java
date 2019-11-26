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
                                System.out.println(users.get(userId).getUsername() + " was approved.\n");
                                checkAttendance(); //TODO
                            }
                            else{ System.out.println(users.get(userId).getUsername() + " was not approved.\n"); }
                        }
                    }
                }
                break;
            }
            break;
        }
    }

    private float printingGrades(int userId, ArrayList<User> users, int professorId, int classId) {
        float mean = 0;
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 4; j++) {
                if (((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j] >= 0) {
                    System.out.println("AV" + (j + 1));
                    System.out.println("Grade: " + ((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j]);
                    mean += ((Professor) users.get(professorId)).classes[professorId][classId].tests[i].testPoints[j];
                }
            }
            return (mean/4);
        }
        return -1;
    }
}
