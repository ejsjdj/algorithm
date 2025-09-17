import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int result = 0;
        
        for (int i = 0; i < str.length(); i++) {
            result = result * 16;
            char now = str.charAt(i);
            if (now == '1') result += 1;
            else if (now == '2') result += 2;
            else if (now == '3') result += 3;
            else if (now == '4') result += 4;
            else if (now == '5') result += 5;
            else if (now == '6') result += 6;
            else if (now == '7') result += 7;
            else if (now == '8') result += 8;
            else if (now == '9') result += 9;
            else if (now == 'A') result += 10;
            else if (now == 'B') result += 11;
            else if (now == 'C') result += 12;
            else if (now == 'D') result += 13;
            else if (now == 'E') result += 14;
            else if (now == 'F') result += 15;
        }
        
        System.out.println(result);
    }
}