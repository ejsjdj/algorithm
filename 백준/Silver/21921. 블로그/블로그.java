import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N + 1];
		for (int i = 1; i <= X; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		
		for (int i = X; i < N + 1; i++) {
			sum[i] = sum[i - 1] + arr[i] - arr[i - X];
		}
		
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (sum[i] > max) {
				max = sum[i];
				cnt = 1;
			}
			else if (sum[i] == max) cnt++;
		}
		
		if (max != 0) {
			System.out.println(max);
			System.out.println(cnt);			
		} else {
			System.out.println("SAD");
		}
	}
}