import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 목표 고객 수
        int C = Integer.parseInt(st.nextToken());
        // 도시의 수
        int N = Integer.parseInt(st.nextToken());

        long[] dp = new long[C + 100];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }
        long minCost = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        System.out.println(minCost);
    }

}