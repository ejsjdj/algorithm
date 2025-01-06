import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N + 1];
		
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(bf.readLine());
			int current = Integer.parseInt(st.nextToken());
			sum[current] = 1;
		}
		
		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + sum[i];
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = K; i < N + 1; i++) {
			int current = sum[i] - sum[i - K];
			if (min > current) min = current;
		}
		System.out.println(min);
	}
}