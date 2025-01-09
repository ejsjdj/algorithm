import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int cnt = 0;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < L; i++) {
			sum += arr[i];
			if (129 <= sum && sum <= 138) cnt++;
		}
		
		for (int i = L; i < N; i++) {
			sum -= arr[i - L];
			sum += arr[i];
			if (129 <= sum && sum <= 138) cnt++;
		}
		
		System.out.println(cnt);
		bf.close();
	}
}