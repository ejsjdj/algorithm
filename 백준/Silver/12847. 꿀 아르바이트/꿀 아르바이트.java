import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max = Integer.MIN_VALUE;
		
		long[] sum = new long[N + 1];
		st = new StringTokenizer(bf.readLine());
		
        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = M; i < N + 1; i++) {
            max = Math.max(sum[i] - sum[i - M], max);
        }
		
		System.out.println(max);
	}
}