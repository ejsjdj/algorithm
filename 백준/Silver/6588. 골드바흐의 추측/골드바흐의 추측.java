import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 최대 입력값을 가정
        int maxNum = 1000000;
        boolean[] isPrime = sieveOfEratosthenes(maxNum);

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            if (num < 4) {
                System.out.println("No solution for " + num);
                continue;
            }

            for (int i = 2; i <= num / 2; i++) {
                if (isPrime[i] && isPrime[num - i]) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    break; // 첫 번째로 발견된 쌍만 출력하고 종료
                }
            }
        }
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}