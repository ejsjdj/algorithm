import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num1 = 0;
		for (int i = 0; i < N; i++) {
			num1 *= 10;
			num1 += 1;
		}
		
		int num2 = 0;
		for (int i = 0; i < M; i++) {
			num2 *= 10;
			num2 += 1;
		}
		
		System.out.println(num1 + num2);
		
	}
}