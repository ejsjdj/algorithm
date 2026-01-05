import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static long MOD = 1_000_000_007;
    public static long[][] matrix = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        
        long[][] result = pow(matrix, n - 1);
        
        System.out.println(result[0][0]);
    }

    // 행렬 제곱 분할 정복 (O(log n))
    public static long[][] pow(long[][] A, long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }

        long[][] temp = pow(A, exp / 2); // 절반 제곱 구하기
        long[][] result = multiply(temp, temp); // 자기 자신 곱하기

        if (exp % 2 == 1) { // 홀수면 A를 한 번 더 곱함
            result = multiply(result, matrix);
        }

        return result;
    }

    // 2x2 행렬 곱셈
    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] ret = new long[2][2];

        // 행렬 곱셈 공식
        // C[i][j] = sum(A[i][k] * B[k][j])
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ret[i][j] += A[i][k] * B[k][j];
                    ret[i][j] %= MOD; // 연산마다 모듈러 연산 필수
                }
            }
        }
        return ret;
    }
}
