import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long sum = 0;
        long cubicSum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
            cubicSum += (long)i * i * i;
        }
        
        long squaredSum = sum * sum;
        
        System.out.println(sum);
        System.out.println(squaredSum);
        System.out.println(cubicSum);
    }
}
