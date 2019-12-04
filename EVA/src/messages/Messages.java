package messages;

import user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Messages {
    public Scanner entry = new Scanner(System.in);
    public void sendingMessages(int userId, ArrayList<User> users){
        System.out.print("Type here a user's username to send a message: ");
        String username = entry.next();
            int k;
        System.out.print("Searching...");
            for (k = 0; k < 500; k++){
                if (username.equals((users.get(k).getUsername()))){
                    System.out.println("User was found.");
                    break;
                }
                else{
                    System.out.println(".");
                }
            }
            for (int j = 0; j < 500;j++) {
                if (users.get(k).messageBox[k][userId][j] == null) {
                    System.out.println("Write down the message you want to send: ");
                    entry.nextLine();
                    String messageToSend = entry.nextLine();
                    users.get(k).messageBox[k][userId][j] = messageToSend;
                    System.out.println("Message succesfully sent.\n");
                    break;
                }
            }
    }
    public void checkMessageBox(int userId, ArrayList<User> users){
        for (int i = 0; i < 500; i++){
            for (int j = 0; j < 500; j++){
                if (users.get(userId).messageBox[userId][i][j] != null) {
                    System.out.println("Message from "+ users.get(i).getUsername() + ":");
                    System.out.println(users.get(userId).messageBox[userId][i][j]);
                    System.out.println();
                }
                else{
                    System.out.println("No message received.");
                }
            }
        }
    }
}
