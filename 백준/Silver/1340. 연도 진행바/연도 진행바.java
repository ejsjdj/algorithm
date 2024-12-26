import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // 월 이름 배열
        String[] months = {
                "January", "February", "March", "April", "May", "June", 
                "July", "August", "September", "October", "November", "December"
        };
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int month = 0;
        int day = Integer.parseInt(str.split(" ")[1].split(",")[0]);
        int year = Integer.parseInt(str.split(" ")[2]);
        int hour = Integer.parseInt(str.split(" ")[3].split(":")[0]);
        int minute = Integer.parseInt(str.split(" ")[3].split(":")[1]);
        
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(str.split(" ")[0])) {
                month = i + 1;
                break;
            }
        }
        
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[1] = 29; 
        }
        
        int totalMinutesInYear = 0;
        for (int days : daysInMonth) {
            totalMinutesInYear += days * 24 * 60;
        }
        
        int minutesUntilToday = 0;
        
        for (int i = 0; i < month - 1; i++) {
            minutesUntilToday += daysInMonth[i] * 24 * 60;
        }
        
        minutesUntilToday += (day - 1) * 24 * 60;
        minutesUntilToday += hour * 60;          
        minutesUntilToday += minute;             
        
        double percentage = (double) minutesUntilToday / totalMinutesInYear * 100;

        System.out.printf("%.10f\n", percentage);
        
        sc.close();
    }
}