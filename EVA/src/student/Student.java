package student;
import user.User;
public class Student extends User{
    int registrationNumber;
    String universityCourse = new String();
    int universityPeriod;
    int ingressionYear;

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getUniversityCourse() { return universityCourse; }

    public void setUniversityCourse(String universityCourse) { this.universityCourse = universityCourse; }

    public int getUniversityPeriod() { return universityPeriod; }

    public void setUniversityPeriod(int universityPeriod) { this.universityPeriod = universityPeriod; }

    public int getIngressionYear() { return ingressionYear; }

    public void setIngressionYear(int ingressionYear) { this.ingressionYear = ingressionYear; }
}
