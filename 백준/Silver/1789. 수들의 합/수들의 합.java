import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long S = sc.nextLong();
        long sum = 0;
        int i = 0;
        
        while (S >= sum) {
            sum += ++i;
        }
        
        System.out.println(i - 1);
        sc.close();
    }
}