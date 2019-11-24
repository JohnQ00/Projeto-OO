package exercises;

public class Lesson {
    String questions[] = new String[100];
    String alternatives[][] = new String[100][5];
    String leadingCourse;
    int lessonAnswer[] = new int[100];
    int numberofQuestions;

    public String getLeadingCourse() {
        return leadingCourse;
    }

    public void setLeadingCourse(String leadingCourse) {
        this.leadingCourse = leadingCourse;
    }


}
