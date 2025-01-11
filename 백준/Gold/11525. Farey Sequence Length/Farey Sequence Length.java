import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        int N = Integer.parseInt(bf.readLine());
        
        // 최대 입력값을 기준으로 에라토스테네스 방식으로 오일러 피 값 미리 계산
        int maxInput = 10000; // 문제 조건에 따라 적절히 설정
        long[] phi = computeTotients(maxInput);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int number = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());

            // Farey 수열 길이 계산
            long fareyLength = computeFareyLength(input, phi);
            sb.append(number).append(" ").append(fareyLength).append("\n");
        }

        bf.close();
        
        // 결과 출력
        System.out.println(sb);
    }

    // 에라토스테네스 방식으로 오일러 피 값 계산
    public static long[] computeTotients(int n) {
        long[] phi = new long[n + 1];
        
        // 초기화: 각 숫자는 자기 자신으로 설정
        for (int i = 0; i <= n; i++) {
            phi[i] = i;
        }
        
        // 에라토스테네스 방식으로 오일러 피 값 계산
        for (int p = 2; p <= n; p++) {
            if (phi[p] == p) { // 소수인 경우
                for (int k = p; k <= n; k += p) {
                    phi[k] -= phi[k] / p;
                }
            }
        }
        
        return phi;
    }

    // Farey 수열의 길이를 계산하는 함수
    public static long computeFareyLength(int n, long[] phi) {
        long length = 1; // 0/1 포함
        
        for (int i = 1; i <= n; i++) {
            length += phi[i]; // 미리 계산된 오일러 피 값 사용
        }
        
        return length;
    }
}