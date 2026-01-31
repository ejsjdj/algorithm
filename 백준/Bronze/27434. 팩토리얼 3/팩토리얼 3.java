import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0 || N == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(factorial(1, N));
    }

    private static BigInteger factorial(int start, int end) {
        if (start == end) {
            return BigInteger.valueOf(start);
        }
        int mid = (start + end) / 2;
        return factorial(start, mid).multiply(factorial(mid + 1, end));
    }
}
