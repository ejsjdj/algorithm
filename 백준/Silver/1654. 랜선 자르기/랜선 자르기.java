import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[K];
        
        long max = 0;
        long min = 1;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        while (max >= min) {
            long cnt = 0;
            long mid = (max + min) / 2;
            for (int i = 0; i < arr.length; i++) cnt += arr[i] / mid;
            if (cnt < N) max = mid - 1;
            else min = mid + 1;
        }
        
        System.out.println(min - 1);
    }
}