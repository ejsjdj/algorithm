import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long count = (long)n * (n - 1) * (n - 2) / 6;

        System.out.println(count);
        System.out.println(3); 

        sc.close();
    }
}