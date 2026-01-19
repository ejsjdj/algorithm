import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int mod = 1_000_003;
    static long[][] matrix;
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        size = 5 * N;

        matrix = new long[size][size];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 5; j++) {
                matrix[5 * i + j][5 * i + j - 1] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int weight = str.charAt(j) - '0';
                if (weight > 0) {
                    matrix[5 * i][5 * j + weight - 1] = 1;
                }
            }
        }

        matrix = matrixPower(matrix, T);

        System.out.println(matrix[5 * (S - 1)][5 * (E - 1)]);
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
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
                result[i][j] = result[i][j] % mod;
            }
        }
        return result;
    }
}