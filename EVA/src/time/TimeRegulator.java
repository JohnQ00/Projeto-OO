package time;

import java.util.Scanner;

public class TimeRegulator {
    Scanner entry = new Scanner(System.in);
    int M2;
    public int countingTime (int Y, int M, int startDayOfMonth){
        int spaces = startDayOfMonth;
        String[] months = {
                "",
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (M != 0) {

            if  ((((Y % 4 == 0) && (Y % 100 != 0)) ||  (Y % 400 == 0)) && M == 2)
                days[M] = 29;
            System.out.println("M antes de M2: " + M);
            M2 = switchingMonths(startDayOfMonth, M - 1, days);
            if (M2 != M){startDayOfMonth = 1;}
            System.out.println("Month: " + M2);
            System.out.println("          "+ months[M2] + " " + Y);

            System.out.println("_____________________________________");
            System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");

            spaces = (days[M2-1] + spaces)%7;

            for (int i = 0; i < spaces; i++)
                System.out.print("     ");
            for (int i = 1; i <= days[M2]; i++) {
                if (i == (startDayOfMonth%days[M2])){
                    System.out.printf(" (%3d) ", i);
                }
                else{
                    System.out.printf(" %3d ", i);
                }
                if (((i + spaces) % 7 == 0) || (i == days[M2])) System.out.println();
            }

            System.out.println();
        }

        return M2;
    }

    private int switchingMonths(int day, int M, int days[]) {
        for (int i = 1; i <= 12; i++){
            if (M == i){
                if (day == days[i]){
                    return M + 2;
                }
            }
        }
        System.out.println("M + 1: " + (M+1));
        return M + 1;
    }
}
