import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        boolean isValid = true;

        for (int n = n0; n <= 100; n++) { 
            if (a1 * n + a0 > c * n) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? 1 : 0);

        sc.close();
    }
}