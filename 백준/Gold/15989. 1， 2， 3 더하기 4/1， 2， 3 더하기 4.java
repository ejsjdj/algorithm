import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 미리 모든 값 계산 (최대 10000)
        int maxN = 10000;
        int[] dp = new int[maxN + 1];
        dp[0] = 1;  // 0을 만드는 방법: 아무것도 선택하지 않기
        
        // 조합 DP: 각 숫자를 순서대로 처리
        for (int coin : new int[]{1, 2, 3}) {
            for (int i = coin; i <= maxN; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        // 결과 출력
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
