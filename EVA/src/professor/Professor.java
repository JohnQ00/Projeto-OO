package professor;
import user.User;
public class Professor extends User {
    int classesQuantity;
    String formation = new String();

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
}
