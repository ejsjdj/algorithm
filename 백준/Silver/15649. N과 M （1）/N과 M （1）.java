import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] arr;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 3
		int K = Integer.parseInt(st.nextToken());	// 2
		
		arr = new boolean[N + 1];
		
		recur(K, "");
		System.out.println(sb);
	}
	
	public static void recur(int coef, String numbers) {
		if (coef > 0) {
			for (int i = 1; i < arr.length; i++) {
				if (!arr[i]) {
					arr[i] = true;
					if (coef > 0) {
						recur(coef - 1, numbers + " " + i);
					}
					arr[i] = false;
				}
			}
		}
		if (coef == 0) sb.append(numbers.subSequence(1, numbers.length())).append("\n");
	}
}