import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		boolean flag = true;
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				if (n != n / i) list.add(n / i);
			}
		}
		list.add(n);
		
		for (int i : list) {
			if (i * eulerPi(i) == n) {
				System.out.println(i);
				flag = false;
				break;
			}
		}
		
		if (flag) System.out.println(-1);
	}
	
	static int eulerPi(int N) {
		int answer = N;
		for (int p = 2; p * p <= N; p++) {
			if (N % p == 0) {
				answer -= answer / p;
				while (N % p == 0) N /= p;
			}
		}
		if (N > 1) answer -= answer / N;
		
		return answer;
	}
}