import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        if (2 + x >= 8) {
            System.out.println("Success!");
        } else {
            System.out.println("Oh My God!");
        }
    }
}
