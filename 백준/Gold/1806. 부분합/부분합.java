import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		
		while (true) {
			while (sum < S && right < N) sum += arr[right++]; 
			while (sum >= S && left < right) {
				len = Math.min(len, right - left);
				sum -= arr[left++];
			}
			if (right == N) break;
		}
		
		System.out.println(len == Integer.MAX_VALUE ? 0 : len);
	}
}