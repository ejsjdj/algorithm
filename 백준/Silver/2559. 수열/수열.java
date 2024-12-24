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
		
		int[] arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		
		for (int i = 0; i < N - K; i++) {
			sum -= arr[i];
			sum += arr[i + K];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}