package exercises;

import professor.Professor;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercisesManagement {
    Scanner entry = new Scanner(System.in);
    Lesson lesson = new Lesson();
    Test test = new Test();

    public void lessonCreation(int userId, ArrayList<User> users){
        lesson = new Lesson();
        System.out.println("Here's the list of your classes: ");
        printingClasses(userId, users);
        System.out.println("Choose a class to send a lesson: ");
        String classChose = entry.next();
        int classId = selectingClass(userId, users, classChose);
        lesson.leadingCourse = classChose;
        for(int i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).classes[userId][classId].lessons[i] == null) {
                ((Professor) users.get(userId)).classes[userId][classId].lessons[i] = lesson;
                break;
            }
        }
        System.out.println("Type the number of questions: ");
        int questions = entry.nextInt();
        creatingQuestions(userId, users, questions, classId);
        System.out.println("Lesson has been created.");
    }

    public void testCreation(int userId, ArrayList<User> users){
        test = new Test();
        System.out.println("Here's the list of your classes: ");
        printingClasses(userId, users);
        System.out.println("Choose a class to send a test: ");
        String classChose = entry.next();
        int classId = selectingClass(userId, users, classChose);
        test.leadingCourse = classChose;
        for(int i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).classes[userId][classId].tests[i] == null) {
                ((Professor) users.get(userId)).classes[userId][classId].tests[i] = test;
                break;
            }
        }
        System.out.print("Type the test number: ");
        int testN = entry.nextInt();
        System.out.print("Type the number of questions: ");
        int questions = entry.nextInt();
        creatingtTestQuestions(userId, users, questions, classId, testN);
        System.out.println("Test has been created.\n");
    }

    private void creatingtTestQuestions(int userId, ArrayList<User> users, int questions, int classId, int testN) {
        for (int i = 0; i < questions;i++){
            ((Professor) users.get(userId)).classes[userId][classId].tests[i].testNumber = testN;

            ((Professor) users.get(userId)).classes[userId][classId].tests[classId].numberofQuestions = questions;
            System.out.println("Write the wording of the question:");
            String wording = entry.next();

            ((Professor) users.get(userId)).classes[userId][classId].tests[classId].questions[i] = wording;
            creatingTestAlternatives(userId, users, classId,i);

            System.out.println("Insert the number of the right alternative: [0 to a)][1 to b)][2 to c)][3 to d)][4 to e)]");
            int rightAnswer = entry.nextInt();
            ((Professor) users.get(userId)).classes[userId][classId].tests[classId].lessonAnswer[i] = rightAnswer;
        }
    }

    private void creatingTestAlternatives(int userId, ArrayList<User> users, int classId, int questionNumber) {
        for (int i = 0; i < 5; i++){
            System.out.println("Insert the alternative text: ");
            String alternatives = entry.next();
            ((Professor) users.get(userId)).classes[userId][classId].tests[classId].alternatives[questionNumber][i] = alternatives;
        }
    }

    private void creatingQuestions(int userId, ArrayList<User> users, int questions, int classId) {
        for (int i = 0; i < questions;i++){
            ((Professor) users.get(userId)).classes[userId][classId].lessons[classId].numberofQuestions = questions;

            System.out.println("Write the wording of the question:");
            String wording = entry.next();

            ((Professor) users.get(userId)).classes[userId][classId].lessons[classId].questions[i] = wording;
            creatingAlternatives(userId, users, classId,i);

            System.out.println("Insert the number of the right alternative: [0 to a)][1 to b)][2 to c)][3 to d)][4 to e)]");
            int rightAnswer = entry.nextInt();
            ((Professor) users.get(userId)).classes[userId][classId].lessons[classId].lessonAnswer[i] = rightAnswer;
        }
    }

    private void creatingAlternatives(int userId, ArrayList<User> users, int classId, int questionNumber) {
        for (int i = 0; i < 5; i++){
            System.out.println("Insert the alternative text: ");
            String alternatives = entry.next();
            ((Professor) users.get(userId)).classes[userId][classId].lessons[classId].alternatives[questionNumber][i] = alternatives;
        }
    }

    private void printingClasses(int userId, ArrayList<User> users){
            for (int j = 0; j< 500; j++){
                if (((Professor) users.get(userId)).classes[userId][j] != null){
                    System.out.println(((Professor) users.get(userId)).classes[userId][j].course);
                }
            }
    }

    public int selectingClass(int userId, ArrayList<User> users, String classChose){
            for (int j = 0; j< 500; j++){
                if (((Professor) users.get(userId)).classes[userId][j] != null) {
                    if (classChose.equals(((Professor) users.get(userId)).classes[userId][j].course)){
                        return j;
                    }
                }
            }
            return -1;
    }

    public void checkingLessons(int userId, ArrayList<User> users, int decision){
        int x = 0;
        if (decision == 8){ yourClassesTests(userId, users, 2);}
        else{yourClasses(userId, users, x);}

    }

    private void yourClassesTests(int userId, ArrayList<User> users, int lessonOrTest) {
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++) {
                for (int k = 0; k < 500; k++){
                    if(((Professor) users.get(i)).classes[i][j] != null){
                        if (users.get(userId).getUsername().equals(((Professor) users.get(i)).classes[i][j].classUsers[k])){
                            System.out.println("The classes you are in: ");
                            System.out.println(((Professor) users.get(i)).classes[i][j].course);
                            checkingClassesTests(userId, users, i, j, lessonOrTest);
                        }
                    }
                }
                break;
            }
            break;
        }
    }

    private void yourClasses(int userId, ArrayList<User> users, int lessonOrTest){
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++) {
                for (int k = 0; k < 500; k++){
                    if(((Professor) users.get(i)).classes[i][j] != null){
                        if (users.get(userId).getUsername().equals(((Professor) users.get(i)).classes[i][j].classUsers[k])){
                            System.out.println("The classes you are in: ");
                            System.out.println(((Professor) users.get(i)).classes[i][j].course);
                            checkingClassesLessons(userId, users, i, j);
                        }
                    }
                }
                break;
            }
            break;
        }
    }

    private void checkingClassesTests(int userId, ArrayList<User> users, int id1, int id2, int lessonOrTest) {
        System.out.println("Checking " + ((Professor) users.get(id1)).classes[id1][id2].course + " tests.");
        for (int i = 0; i < 500; i++){
            if(((Professor) users.get(id1)).classes[id1][id2].tests[i] != null){
                System.out.println("Do you wish to answer this test now ? [0 to No][1 to Yes]");
                System.out.print("Type here: ");
                int decision = entry.nextInt();
                if (decision == 1) {
                    printingTestQuestions(userId, users, id1, id2, i,lessonOrTest);
                }
            }
        }
        System.out.println("No more tests.");
    }

    private void checkingClassesLessons(int userId, ArrayList<User> users, int id1, int id2) {
        System.out.println("Checking " + ((Professor) users.get(id1)).classes[id1][id2].course + " lessons.");
        for (int i = 0; i < 500; i++){
            if(((Professor) users.get(id1)).classes[id1][id2].lessons[i] != null){
                    System.out.println("Do you wish to answer this lesson now ? [0 to No][1 to Yes]");
                    System.out.print("Type here: ");
                    int decision = entry.nextInt();
                    if (decision == 1) {
                        printingQuestions(userId, users, id1, id2, i);
                    }
            }
        }
        System.out.println("No more lessons.");
    }

    private void printingQuestions(int userId, ArrayList<User> users, int id1, int id2, int id3) {
        int countingCorrect = 0;
        for (int i = 0; i < ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].numberofQuestions ;i++){
            if (((Professor)users.get(id1)).classes[id1][id2].lessons[id3].questions[i] != null) {
                System.out.println("Showing the lesson's wording: ");
                System.out.println(((Professor) users.get(id1)).classes[id1][id2].lessons[id3].questions[i]);
            }
            for (int j = 0; j < 5;j++){
                if (((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j] != null) {
                    if (j == 0)
                        System.out.println("a)" + ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j]);
                    else if (j == 1)
                        System.out.println("b)" + ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j]);
                    else if (j == 2)
                        System.out.println("c)" + ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j]);
                    else if (j == 3)
                        System.out.println("d)" + ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j]);
                    else if (j == 4)
                        System.out.println("e)" + ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].alternatives[i][j]);
                }
            }
            System.out.println("\nType your answer: [0 to a)][1 to b)][2 to c)][3 to d)][4 to e)]");
            int answer = entry.nextInt();

            if (answer == ((Professor)users.get(id1)).classes[id1][id2].lessons[id3].lessonAnswer[i]){
                System.out.println("You are correct.");
                countingCorrect++;
            }
            else{
                System.out.println("You are wrong.");
            }
        }
        int percentage = (countingCorrect/((Professor)users.get(id1)).classes[id1][id2].lessons[id3].numberofQuestions) * 100;
        System.out.println("Percentage of right answers: " + percentage + "%");

    }

    private void printingTestQuestions(int userId, ArrayList<User> users, int id1, int id2, int id3, int lessonOrTest) {
        int countingCorrect = 0;
        for (int i = 0; i < ((Professor)users.get(id1)).classes[id1][id2].tests[id3].numberofQuestions ;i++){
            if (((Professor)users.get(id1)).classes[id1][id2].tests[id3].questions[i] != null) {
                System.out.println("\nShowing the test's wording: ");
                System.out.println(((Professor) users.get(id1)).classes[id1][id2].tests[id3].questions[i]);
            }
            for (int j = 0; j < 5;j++){
                if (((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j] != null) {
                    if (j == 0)
                        System.out.println("a)" + ((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j]);
                    else if (j == 1)
                        System.out.println("b)" + ((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j]);
                    else if (j == 2)
                        System.out.println("c)" + ((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j]);
                    else if (j == 3)
                        System.out.println("d)" + ((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j]);
                    else if (j == 4)
                        System.out.println("e)" + ((Professor)users.get(id1)).classes[id1][id2].tests[id3].alternatives[i][j]);
                }
            }
            System.out.println("\nType your answer: [0 to a)][1 to b)][2 to c)][3 to d)][4 to e)]");
            int answer = entry.nextInt();
                if (answer == ((Professor)users.get(id1)).classes[id1][id2].tests[id3].lessonAnswer[i]){ countingCorrect++; }
        }
        float grade = ((countingCorrect * 10) / ((Professor) users.get(id1)).classes[id1][id2].tests[id3].numberofQuestions);
        ((Professor) users.get(id1)).classes[id1][id2].tests[id3].testPoints[((Professor) users.get(id1)).classes[id1][id2].tests[id3].testNumber] = grade;

    }

}
