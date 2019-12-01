package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionManagement {
    Scanner entry = new Scanner(System.in);

    public int scanInt(String message){
        int integer = 0;
        while(true) {
            try {
                System.out.print(message);
                integer = entry.nextInt();
                entry.nextLine();
                break;
            } catch (InputMismatchException e) {
                entry.nextLine();
                System.out.println("The entered value it has to be an integer.\nPress enter to try again.");
                entry.nextLine();
            }
        }
        return integer;
    }

}
