import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] matrix = {{1, 1}, {1, 0}};
    static long mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = gcd(a,b);
            System.out.println(matrixPower(matrix, c)[0][1]);
            matrix = new long[][]{{1, 1}, {1, 0}};
        }

    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long[][] matrixPower(long[][] matrix, long T) {
        if (T == 1) return matrix;

        if (T % 2 == 0) {
            long[][] half = matrixPower(matrix, T / 2);
            return matrixMultiply(half, half);
        } else {
            return matrixMultiply(matrix, matrixPower(matrix, T - 1));
        }
    }

    static long[][] matrixMultiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
                result[i][j] = result[i][j] % mod;
            }
        }
        return result;
    }
}