import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a * 81 <= b * 100) System.out.println("yaho");
        else System.out.println("no");
    }
}