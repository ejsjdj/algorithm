import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        dp[N] = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1; // 기다리기
            
            if (i + a + 1 <= N) {
                dp[i] = Math.min(dp[i], dp[i + a + 1] + 1);
            }
            
            if (i + b + 1 <= N) {
                dp[i] = Math.min(dp[i], dp[i + b + 1] + 1);
            }
        }
        
        System.out.println(dp[0]);
    }
}