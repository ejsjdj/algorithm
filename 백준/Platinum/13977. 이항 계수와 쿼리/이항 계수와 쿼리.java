import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        long[] fac = new long[4_000_001];

        fac[1] = 1;
        fac[0] = 1;
        for (int i = 2; i <= 4_000_000; i++) {
            fac[i] = fac[i - 1] * i % mod;
        }
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long numerator = fac[N];
            long inverse = power(fac[K] * fac[N - K] % mod, mod - 2);
            long result = numerator * inverse % mod;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static long power(long base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base % mod;

        long half = power(base, exp / 2);
        half = (half * half) % mod;

        if (exp % 2 == 1) {
            half = (half * base) % mod;
        }
        return half % mod;
    }
}