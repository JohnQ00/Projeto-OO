package exercises;

import exceptions.ExceptionManagement;
import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercisesManagement {
    // id1 = ProfessorId , id2 = ClassId
    Scanner entry = new Scanner(System.in);
    Lesson lesson = new Lesson();
    Test test = new Test();
    ExceptionManagement Exceptions = new ExceptionManagement();

    public void lessonCreation(int userId, ArrayList<User> users){
        lesson = new Lesson();
        System.out.println("[ Don't overload your students.]\n");
        System.out.println("Here's the list of your classes: ");
        printingClasses(userId, users);
        System.out.println("Choose a class to send a lesson: ");
        String classChose = entry.nextLine();
        System.out.println("Press enter to confirm");
        entry.nextLine();
        int classId = selectingClass(userId, users, classChose);
        if(classId < 0 || classId >= 500){
            return;
        }
        lesson.setLeadingCourse(classChose);
        int i = 0;
        for(i = 0; i < 500; i++) {
            if(((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[i] == null) {
                ((Professor) users.get(userId)).getClasses()[userId][classId].setLessons(lesson);
                break;
            }
        }
        int questions = Exceptions.scanInt("Type the number of questions: ");
        creatingQuestions(userId, users, questions, classId, i);
        System.out.println("Lesson has been created.");
    }

    public int returningProfessorId(int userId, ArrayList<User> users){
        System.out.println("Showing your classes: ");
        for (int i = 0; i < 500; i++){
            if (((Student) users.get(userId)).getCoursesIn()[i] != null){
                System.out.println(((Student) users.get(userId)).getCoursesIn()[i]);
            }
        }
        System.out.print("Choose a class: ");
        String choice = entry.nextLine();
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++){
                if (choice.equals(((Professor) users.get(i)).getClasses()[i][j].getCourse())){
                    System.out.println("Starting the lesson creation system.");
                    return i;
                }
            }
        }
        return -1;
    }

    public void testCreation(int userId, ArrayList<User> users){
        test = new Test();
        System.out.println("\n[ One test for each login. ]");
        System.out.println("[ Don't overload your students.]\n");
        System.out.println("Here's the list of your classes: ");
        printingClasses(userId, users);
        System.out.println("Choose a class to send a test: ");
        String classChose = entry.nextLine();
        int classId = selectingClass(userId, users, classChose);
        if(classId < 0 || classId >= 500){
            return;
        }
        test.setLeadingCourse(classChose);
        int i = 0;
        for(i=0; i < 500; i++) {
            if(((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[i] == null) {
                ((Professor) users.get(userId)).getClasses()[userId][classId].setTests(test);
                break;
            }
        }
        int testN = Exceptions.scanInt("Type the test number: ");
        int questions = Exceptions.scanInt("Type the number of questions: ");
        creatingtTestQuestions(userId, users, questions, classId, testN, i);
        System.out.println("Test has been created.\n");
    }

    private void creatingtTestQuestions(int userId, ArrayList<User> users, int questions, int classId, int testN, int testId) {
        for (int i = 0; i < questions;i++){
            ((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[testId].setTestNumber(testN);

            ((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[testId].setNumberofQuestions(questions);
            System.out.println("Write the wording of the question:");
            String wording = entry.next();

            ((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[testId].setQuestions(wording);
            creatingTestAlternatives(userId, users, classId,i, testId);


            while(true) {
                System.out.print("Insert the right alternative: ");
                String rightAnswer = entry.next();
                if (rightAnswer.equalsIgnoreCase("a")
                        || rightAnswer.equalsIgnoreCase("b")
                        || rightAnswer.equalsIgnoreCase("c")
                        || rightAnswer.equalsIgnoreCase("d")
                        || rightAnswer.equalsIgnoreCase("e")) {
                    ((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[testId].setLessonAnswer(rightAnswer);;
                    break;
                }
                else {
                    System.out.println("Enter a valid alternative.");
                }
            }

        }
    }

    private void creatingTestAlternatives(int userId, ArrayList<User> users, int classId, int questionNumber, int testId) {
        for (int i = 0; i < 5; i++){
            System.out.println("Insert the alternative text: ");
            String alternatives = entry.next();
            ((Professor) users.get(userId)).getClasses()[userId][classId].getTests()[testId].alternatives[questionNumber][i] = alternatives;
        }
    }

    private void creatingQuestions(int userId, ArrayList<User> users, int questions, int classId, int lessonId) {
        if (((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[lessonId] != null) {
            for (int i = 0; i < questions; i++) {
                ((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[lessonId].setNumberofQuestions(questions);

                System.out.println("Write the wording of the question:");
                String wording = entry.next();

                ((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[lessonId].setQuestions(wording);
                creatingAlternatives(userId, users, classId, i, lessonId);

                while (true) {
                    System.out.print("Insert the right alternative: ");
                    String rightAnswer = entry.next();
                    if (rightAnswer.equalsIgnoreCase("a")
                            || rightAnswer.equalsIgnoreCase("b")
                            || rightAnswer.equalsIgnoreCase("c")
                            || rightAnswer.equalsIgnoreCase("d")
                            || rightAnswer.equalsIgnoreCase("e")) {
                        ((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[lessonId].setLessonAnswer(rightAnswer);
                        break;
                    } else {
                        System.out.println("Enter a valid alternative.");
                    }
                }
            }
        }
    }

    //overload
    private void creatingAlternatives(int userId, ArrayList<User> users, int classId, int questionNumber, int lessonId) {
        for (int i = 0; i < 5; i++){
            System.out.println("Insert the alternative text: ");
            String alternatives = entry.next();
            ((Professor) users.get(userId)).getClasses()[userId][classId].getLessons()[lessonId].alternatives[questionNumber][i] = alternatives;
        }
    }

    //overload
    public void printingClasses(int userId, ArrayList<User> users){
        for (int j = 0; j< 500; j++){
            if (((Professor) users.get(userId)).getClasses()[userId][j] != null){
                System.out.println(((Professor) users.get(userId)).getClasses()[userId][j].getCourse());
            }
        }
    }

    //overload
    public int selectingClass(int userId, ArrayList<User> users, String classChose){
        for (int j = 0; j< 500; j++){
            if (((Professor) users.get(userId)).getClasses()[userId][j] != null) {
                if (classChose.equals(((Professor) users.get(userId)).getClasses()[userId][j].getCourse())){
                    return j;
                }
            }
            else{
                System.out.println("The class doesn't exist.\n");
                return 500;
            }
        }

        return 500;
    }

    public void checkingLessonsAndTests(int userId, ArrayList<User> users, int decision){
        int x = 0;
        if (decision == 8){ yourClassesTests(userId, users, 2);}
        else{yourClasses(userId, users, x);}

    }

    private void yourClassesTests(int userId, ArrayList<User> users, int lessonOrTest) {
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++) {
                for (int k = 0; k < 500; k++){
                    if(((Professor) users.get(i)).getClasses()[i][j] != null){
                        if (users.get(userId).getUsername().equals(((Professor) users.get(i)).getClasses()[i][j].getClassUsers()[k])){
                            System.out.println("The classes you are in: ");
                            System.out.println(((Professor) users.get(i)).getClasses()[i][j].getCourse());
                            checkingClassesTests(userId, users, i, j, lessonOrTest, ((Professor)users.get(i)).getClasses()[i][j].getTests()[k].getNumberofQuestions());
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
                    if(((Professor) users.get(i)).getClasses()[i][j] != null){
                        if (users.get(userId).getUsername().equals(((Professor) users.get(i)).getClasses()[i][j].getClassUsers()[k])){
                            System.out.println("The classes you are in: ");
                            System.out.println(((Professor) users.get(i)).getClasses()[i][j].getCourse());
                            checkingClassesLessons(userId, users, i, j, ((Professor) users.get(i)).getClasses()[i][j].getLessons()[k].getNumberofQuestions());
                        }
                    }
                }
                break;
            }
            break;
        }
    }

    private void checkingClassesTests(int userId, ArrayList<User> users, int id1, int id2, int lessonOrTest, int fullQuestionNum) {
        System.out.println("Checking " + ((Professor) users.get(id1)).getClasses()[id1][id2].getCourse() + " tests.");
        for (int i = 0; i < 4; i++){
            if(((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[i] != null && ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[i].isAnswered() == false ){
                System.out.println("Do you wish to answer this test now ? [0 to No][1 to Yes]");
                int decision = Exceptions.scanInt("Type here: ");
                if (decision == 1) {
                    printingTestQuestions(userId, users, id1, id2, i,lessonOrTest, fullQuestionNum);
                }
            }
        }
        System.out.println("No more tests.\n");
    }

    private void checkingClassesLessons(int userId, ArrayList<User> users, int id1, int id2, int fullQuestionNum) {
        System.out.println("Checking " + ((Professor) users.get(id1)).getClasses()[id1][id2].getCourse() + " lessons.");
        for (int i = 0; i < 500; i++){
            if(((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[i] != null &&  ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[i].isAnswered() == false){
                System.out.println("Do you wish to answer this lesson now ? [0 to No][1 to Yes]");
                int decision = Exceptions.scanInt("Type here: ");
                if (decision == 1) {
                    printingQuestions(userId, users, id1, id2, i, fullQuestionNum);
                }
            }
        }
        System.out.println("No more lessons.\n");
    }

    private void printingQuestions(int userId, ArrayList<User> users, int id1, int id2, int lessonId, int fullQuestionNum) {
        int countingCorrect = 0;
            for (int i = 0; i < ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].getNumberofQuestions(); i++) {
                if (((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].getQuestions()[i] != null) {
                    System.out.println("Showing the lesson's wording: ");
                    System.out.println(((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].getQuestions()[i]);
                }
                for (int j = 0; j < 5; j++) {
                    if (((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j] != null) {
                        if (j == 0)
                            System.out.println("a)" + ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j]);
                        else if (j == 1)
                            System.out.println("b)" + ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j]);
                        else if (j == 2)
                            System.out.println("c)" + ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j]);
                        else if (j == 3)
                            System.out.println("d)" + ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j]);
                        else if (j == 4)
                            System.out.println("e)" + ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].alternatives[i][j]);
                    }
                }
                System.out.print("\nType your answer: ");
                String answer = entry.next();

                if (answer.equalsIgnoreCase(((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].getLessonAnswer()[i])) {
                    System.out.println("You are correct.");
                    countingCorrect++;
                } else {
                    System.out.println("You are wrong.");
                }
            }
            System.out.println("The number of right answers: " + countingCorrect);
            ((Professor) users.get(id1)).getClasses()[id1][id2].getLessons()[lessonId].setAnswered(true);
    }

    private void printingTestQuestions(int userId, ArrayList<User> users, int id1, int id2, int testId, int lessonOrTest, int fullQuestionNum) {
        int countingCorrect = 0;
        for (int i = 0; i < ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].getNumberofQuestions() ;i++){
            if (((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].getQuestions()[i] != null) {
                System.out.println("\nShowing the test's wording: ");
                System.out.println(((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].getQuestions()[i]);
            }
            for (int j = 0; j < 5;j++){
                if (((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j] != null) {
                    if (j == 0)
                        System.out.println("a)" + ((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j]);
                    else if (j == 1)
                        System.out.println("b)" + ((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j]);
                    else if (j == 2)
                        System.out.println("c)" + ((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j]);
                    else if (j == 3)
                        System.out.println("d)" + ((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j]);
                    else if (j == 4)
                        System.out.println("e)" + ((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].alternatives[i][j]);
                }
            }
            System.out.print("\nType your answer: ");
            String answer = entry.next();
            if (answer.equalsIgnoreCase(((Professor)users.get(id1)).getClasses()[id1][id2].getTests()[testId].getLessonAnswer()[i])){ countingCorrect++; }
        }
        float grade = ((countingCorrect * 10) / ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].getNumberofQuestions());
        int testPIndex = ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].getTestNumber();
        ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].setTestPoints(grade, testPIndex);
        ((Professor) users.get(id1)).getClasses()[id1][id2].getTests()[testId].setAnswered(true);
    }

}
