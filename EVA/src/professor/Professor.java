package professor;
import classes.Classes;
import user.User;

import java.util.ArrayList;

public class Professor extends User {
    int classesQuantity;
    String formation = new String();
    String specialization = new String();
    String disciplines[][] = new String[500][500];
    public Classes classes[][] = new Classes[500][500];

    public int getClassesQuantity() {
        return classesQuantity;
    }

    public void setClassesQuantity(int classesQuantity) {
        this.classesQuantity = classesQuantity;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }
}
