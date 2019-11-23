package user;

import classes.Classes;

import java.util.ArrayList;

public abstract class User {
    String cpf = new String();
    String password = new String();
    String username = new String();

    String fullName = new String();
    String email = new String();
    int age;
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
