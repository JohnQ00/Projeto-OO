package classes;

import exercises.Lesson;
import exercises.Test;

public class Classes {
    public String creator = new String();
    int monitors[] = new int[500];
    public String course = new String();
    public String classUsers[] = new String[500];
    int vacancies;
    public Lesson lessons[] = new Lesson[500];
    public Test tests[] = new Test[500];

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
