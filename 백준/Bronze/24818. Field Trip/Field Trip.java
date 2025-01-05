import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int first = 0;
		int second = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int[] sum = new int[N+1];
		sum[0] = 0;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			if (sum[N] == sum[i] * 3) {
				first = i;
				break;
			}
		}
		
		for (int i = first + 1; i < N; i++) {
			if (sum[N] == (sum[i] - sum[first]) * 3) {
				second = i;
				break;
			}
		}
		
		if (first != 0 && second != 0) System.out.println(first + " " + second);
		else System.out.println(-1);
	}
}