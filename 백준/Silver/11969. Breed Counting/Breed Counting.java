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
		
		int[] sum1 = new int[N + 1];
		int[] sum2 = new int[N + 1];
		int[] sum3 = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int cow = Integer.parseInt(st.nextToken());
			if (cow == 1) {
				sum1[i + 1]++;
			} else if (cow == 2) {
				sum2[i + 1]++;
			} else if (cow == 3) {
				sum3[i + 1]++;
			}
			sum1[i + 1] += sum1[i];
			sum2[i + 1] += sum2[i];
			sum3[i + 1] += sum3[i];
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			System.out.println((sum1[right] - sum1[left - 1]) + " " + (sum2[right] - sum2[left - 1]) + " " + (sum3[right] - sum3[left - 1]));
		}
		bf.close();
	}
}