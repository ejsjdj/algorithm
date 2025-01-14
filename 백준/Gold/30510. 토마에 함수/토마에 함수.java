import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int gcd = GCD(P, Q);
		
		P =  P / gcd;
		Q = Q / gcd;
		int i = 1;
		long sum = 0;
		while (P * i <= Q) {
			sum += eulerPi(i);
			i += 1;
		}
		System.out.println(sum+1);
	}
	
	static int GCD (int P, int Q) {
		while (Q != 0) {
			int r = P % Q;
			P = Q;
			Q = r;
		}
		return P;
	}
	
	static int eulerPi (int Q) {
		
		int result = Q;
		int N = Q;
		
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				result -= result / i;
				while (N % i == 0) {
					N /= i;
				}
			}
		}
		
		if (N > 1) result -= result/N;
		return result;
	}
}