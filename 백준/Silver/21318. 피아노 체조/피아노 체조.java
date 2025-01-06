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
		
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] < arr[i - 1]) sum[i] = sum[i - 1] + 1;
			else sum[i] = sum[i - 1];
		}
		
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(sum[right] - sum[left] + "\n");
		}
		
		System.out.println(sb);
	}
}