import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            int N = Integer.parseInt(br.readLine());

            int result = eulerPi(N);

            if (N % 2 == 0) {
                result += eulerPi(N / 2);
            }

            System.out.println(result);
        }

    }

    static int eulerPi(int n) {
        int result = n - 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result -= result / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}