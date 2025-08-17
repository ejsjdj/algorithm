import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Item {
        int weight, value;
        Item(int w, int v) { weight = w; value = v; }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Item> items = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());  // 무게
            int c = Integer.parseInt(st.nextToken());  // 만족도
            int k = Integer.parseInt(st.nextToken());  // 개수
            
            // Binary splitting: k개를 1, 2, 4, 8, ... 로 분할
            int cnt = 1;
            while (cnt <= k) {
                items.add(new Item(v * cnt, c * cnt));
                k -= cnt;
                cnt *= 2;
            }
            if (k > 0) {
                items.add(new Item(v * k, c * k));
            }
        }
        
        // 일반적인 0-1 배낭 문제로 해결
        int[] dp = new int[M + 1];
        
        for (Item item : items) {
            for (int i = M; i >= item.weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - item.weight] + item.value);
            }
        }
        
        System.out.println(dp[M]);
    }
}