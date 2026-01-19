import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1_000_000_007;
    static final int SIZE = 8;
    static long[][] adjacency = {
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());

        System.out.println(matrixPower(adjacency, D)[0][0]);

    }

    static long[][] matrixPower(long[][] matrix, long n) {
        if (n == 1) return matrix;

        if (n % 2 == 0) {
            long[][] half = matrixPower(matrix, n / 2);
            return mul_matrix(half, half);
        } else {
            return mul_matrix(matrix, matrixPower(matrix, n - 1));
        }
    }

    static long[][] mul_matrix(long[][] matrix1, long[][] matrix2) {

        long[][] result = new long[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    result[i][j] = result[i][j] % MOD;
                }
            }
        }
        return result;

    }

}