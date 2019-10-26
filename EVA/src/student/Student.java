package student;
import user.User;
public class Student extends User{
    int registrationNumber;
    int connectedTime;
    String ingressionYear = new String();

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getConnectedTime() {
        return connectedTime;
    }

    public void setConnectedTime(int connectedTime) {
        this.connectedTime = connectedTime;
    }
}
