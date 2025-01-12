import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 0;

		while (a != b) {
			cnt++;
			int A = Math.max(a, b) - Math.min(a, b);
			int B = Math.min(a, b);
			a = A;
			b = B;
		}
		System.out.println(cnt);
	}
}