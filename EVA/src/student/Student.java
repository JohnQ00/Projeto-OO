package student;
import user.User;
public class Student extends User{
    int registrationNumber;
    public String universityDiscipline = new String();
    int universityPeriod;
    int ingressionYear;
    public String coursesIn[] = new String[500];

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getUniversityDiscipline() { return universityDiscipline; }

    public void setUniversityDiscipline(String universityDiscipline) { this.universityDiscipline = universityDiscipline; }

    public int getUniversityPeriod() { return universityPeriod; }

    public void setUniversityPeriod(int universityPeriod) { this.universityPeriod = universityPeriod; }

    public int getIngressionYear() { return ingressionYear; }

    public void setIngressionYear(int ingressionYear) { this.ingressionYear = ingressionYear; }
}
