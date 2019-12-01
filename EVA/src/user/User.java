package user;

public abstract class User {
    private String cpf = new String();
    private String password = new String();
    private String username = new String();

    private String fullName = new String();
    private String email = new String();
    private int age;

    public String messageBox[][][] = new String[500][500][500];

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
