import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] sum1 = new int[N];
		int[] sum2 = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		sum1[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			sum1[i] = sum1[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		sum2[0] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		if (sum2[0] == sum1[0]) {
			answer = 1;
		}
		for (int i = 1; i < N; i++) {
			
			sum2[i] = sum2[i - 1] + Integer.parseInt(st.nextToken());
			
			if (sum2[i] == sum1[i]) {
				answer = i + 1;
			}
		}
		
		System.out.println(answer);
		
	}
}