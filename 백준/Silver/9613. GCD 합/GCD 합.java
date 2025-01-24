import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 숫자의 개수
            int[] numbers = new int[M];

            // 숫자 입력 받기
            for (int j = 0; j < M; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0;

            // 모든 쌍의 GCD 계산 및 합산
            for (int j = 0; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    result += GCD(numbers[j], numbers[k]);
                }
            }

            System.out.println(result);
        }
    }

    // 최대공약수(GCD) 계산 함수
    static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}