package exercises;

public class Lesson {
    private int index = 0;
    private int qIndex = 0;
    private String questions[] = new String[100];
    public String alternatives[][] = new String[100][5];
    private String leadingCourse;
    private String lessonAnswer[] = new String[100];
    private int numberofQuestions;

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions[qIndex] = questions;
        qIndex++;
    }

//    public String[][] getAlternatives() {
//        return alternatives;
//    }
//
//    public void setAlternatives(String[][] alternatives) {
//        this.alternatives = alternatives;
//    }

    public String[] getLessonAnswer() {
        return lessonAnswer;
    }

    public void setLessonAnswer(String lessonAnswer) {
        this.lessonAnswer[index] = lessonAnswer;
        index++;
    }

    public int getNumberofQuestions() {
        return numberofQuestions;
    }

    public void setNumberofQuestions(int numberofQuestions) {
        this.numberofQuestions = numberofQuestions;
    }

    public String getLeadingCourse() {
        return leadingCourse;
    }

    public void setLeadingCourse(String leadingCourse) {
        this.leadingCourse = leadingCourse;
    }
}
