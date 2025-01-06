import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N + 1];
		sum[0] = 0;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(sum[right] - sum[left - 1] + "\n");
		}
		
		System.out.println(sb);
		bf.close();
	}
}