package classes;

public class Classes {
    public String creator = new String();
    int monitors[][] = new int[500][500];
    public String course = new String();
    String classUsers[] = new String[500];
    int vacancies;

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
