import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        
        int prev2 = 1;  // dp[i-2]
        int prev1 = 2;  // dp[i-1]
        int current = 0;
        
        for (int i = 3; i <= N; i++) {
            current = (prev1 + prev2) % 15746;
            prev2 = prev1;
            prev1 = current;
        }
        
        System.out.println(current);
    }
}
