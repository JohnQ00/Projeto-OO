package main;

import exceptions.ExceptionManagement;
import user.User;
import profile.ProfileManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPage {

    ///ArrayList////////////////////////////////////////////////////////////////////////////////////////
    public final int max = 500;
    ArrayList<User> users = new ArrayList<User>(max);
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ExceptionManagement Exceptions = new ExceptionManagement();
    ProfileManagement ProfileM = new ProfileManagement();
    public User user;

    public Scanner input = new Scanner(System.in);

    public void Init(){
    while(true){
        TextOptions.options();
        int choice = Exceptions.scanInt("Type here: ");
        if(choice == 0){
            System.out.println("\nClosing the system.");
            break;
        }

        ProfileM.accountOptions(choice,user,users);
    }

    }
}
