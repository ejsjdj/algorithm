import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			sum[i] = sum [i - 1]+ Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N - 1; i++) {
			int now = Math.abs(sum[N-1] - 2 * sum[i]);
			if (answer > now) answer = now;
		}
		
		System.out.println(answer);
	}
}