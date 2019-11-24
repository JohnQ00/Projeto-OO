package student;

import user.User;
import exercises.ExercisesManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MonitorManagement {
    Scanner entry = new Scanner(System.in);
    ExercisesManagement ManagingMonitor = new ExercisesManagement();
    public void turnIntoMonitor(int userId, ArrayList<User> users){
        System.out.println("Showing all of your classes: ");
        ManagingMonitor.printingClasses(userId, users);
        System.out.println("Choose a class:");
        String classC = entry.next();
    }
}
