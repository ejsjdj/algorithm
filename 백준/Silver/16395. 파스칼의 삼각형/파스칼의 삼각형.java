import java.util.Scanner;

public class Main {
    public static long combination(int n, int k) {
        if (k < 0 || n < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        // nCk == nC(n - k)
        if (k > n - k) k = n - k;
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1;
        int k = sc.nextInt() - 1;
        System.out.println(combination(n, k));
        sc.close();
    }
}