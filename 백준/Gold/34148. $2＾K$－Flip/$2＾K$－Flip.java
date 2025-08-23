import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 998244353;
    
    private static long power(long base, long exp) {
        long result = 1;
        base = base % MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            exp = exp >> 1;
            base = (base * base) % MOD;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        boolean[] touched = new boolean[N];
        int[] diff = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken());
            
            diff[left]++;
            diff[right]--;
        }
        int curr = 0;
        for (int i = 0; i < N; i++) {
        	curr += diff[i];
        	if (curr > 0) touched[i] = true;
        }
        
        long pow2K = power(2, K);
        long pow2K_minus_1 = power(2, K-1);
        
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (!touched[i]) {
                result = (result + (A[i] * pow2K) % MOD) % MOD;
            } else {
                result = (result + pow2K_minus_1) % MOD;
            }
        }
        
        System.out.println(result);
    }
}