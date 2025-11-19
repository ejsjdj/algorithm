import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		arr[0] = 0;
		
		// 새치기 하는것 구현
		for (int i = 0; i <= N; i++) {
			if (i + 1 <= N) arr[i + 1] = Math.min(arr[i + 1], arr[i] + 1);
			if (i + a + 1 <= N) arr[i + a + 1] = Math.min(arr[i] + 1, arr[i + a + 1]);
			if (i + b + 1 <= N) arr[i + b + 1] = Math.min(arr[i] + 1, arr[i + b + 1]);
		}
		
		System.out.println(arr[N]);
	}
}