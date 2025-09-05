import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        System.out.println((int)(N * 0.78));
        System.out.println((int)((N * 0.8) + (N * 0.2 * 0.78)));
        
        sc.close();
    }
}