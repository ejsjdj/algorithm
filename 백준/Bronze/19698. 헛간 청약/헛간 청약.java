import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int L = sc.nextInt();
        
        int widthCows = W / L;
        int heightCows = H / L;
        int maxCows = widthCows * heightCows;
        
        System.out.println(Math.min(N, maxCows));
    }
}
