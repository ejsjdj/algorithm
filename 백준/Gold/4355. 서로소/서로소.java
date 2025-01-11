import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			long n = Long.parseLong(st.nextToken());
			
			if (n == 0)
				break;
			long result = n;
			if (n == 1) result = 0;
			else {
				for (long p = 2; p * p <= n; p++) {
					if (n % p == 0) {
						result = result - result / p;
						while (n % p == 0) {
							n /= p;
						}
					}
				}
				if (n > 1) result = result - result / n;				
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}