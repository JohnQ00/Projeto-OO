package main;

import professor.Professor;
import student.Student;
import user.User;
import profile.ProfileManagement;

import java.util.ArrayList;
import java.util.Scanner;

import static profile.ProfileManagement.accountOptions;

public class MainPage {

    ///ArrayList////////////////////////////////////////////////////////////////////////////////////////
    public static final int max = 500;
    ArrayList<User> users = new ArrayList<User>(max);
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Student s = new Student();

    public static int counter = 0;

    public static Scanner input = new Scanner(System.in);

    public void Init(){
    while(true){
        TextOptions.options();
        System.out.print("Type here: ");
        int choice = input.nextInt();
        if(choice == 0){
            System.out.println("Closing the system.");
            break;
        }

        accountOptions(counter,choice,s,users);

//        s.setFullName("Claudinhu");
//        s.setEmail("claudiows@gmail.com");
//        s.setCpf("13662512459");
//        s.setRegistrationNumber(10192);

//        users.add(s);
//
//
//        Professor p = new Professor();
//        p.setCpf(s.getCpf());
//        p.setFullName(s.getFullName());
//        p.setEmail(s.getEmail());
//        p.setClassesQuantity(10);
//
//        users.set(0,p);



    }

    }

//    private int getId(String username, String password) {
//
//        for (int i = 0; i < users.size(); i++){
//            if (users.get(i).getUsername().equals(username))
//                if(users.get(i).getPassword().equals(password))
//                    return i;
//
//        }
//        return -1;
//    }


}
