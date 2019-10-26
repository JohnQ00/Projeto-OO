package profile;

import main.MainPage;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileManagement {
    public static Scanner entry = new Scanner(System.in);
    public static void accountOptions(int counter, int choice, Student s, ArrayList<User> users){
        if (choice == 1){
            System.out.print("CPF: ");
            s.setCpf(entry.next());
            System.out.print("Username: ");
            s.setUsername(entry.next());
            System.out.print("Password: ");
            s.setPassword(entry.next());

            users.add(s);
            //counter++;

            System.out.println("You succesfully created an account.");
            s.setCpf("zezin");
            s.setUsername("zezin");
            s.setPassword("zezin");

        }
        if (choice == 3){
            System.out.print("CPF: ");
            String cpf = entry.next();
            System.out.print("Password: ");
            String password = entry.next();

            searchUsers(cpf,password,s,users);
        }

    }

    public static void searchUsers(String cpf, String password, Student s, ArrayList<User> users){

        for (int i = 0; i < 4; i++) {
            System.out.println(users.get(i).getCpf());
            System.out.println(users.get(i).getPassword());
            if (users.get(i).getCpf().equalsIgnoreCase(cpf) && users.get(i).getPassword().equalsIgnoreCase(password))
                System.out.println("\nLogin was done.\n");
            else
                System.out.println("\nLogin was not done.\n");
        }
    }
}
