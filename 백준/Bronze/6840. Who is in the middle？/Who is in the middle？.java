import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int[] weights = {a, b, c};
        java.util.Arrays.sort(weights);
        
        System.out.println(weights[1]);
    }
}