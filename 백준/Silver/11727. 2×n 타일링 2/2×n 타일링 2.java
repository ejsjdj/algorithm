import java.util.Scanner;

public class Main {
	
	static int mod = 10007;
	static int[] memo;
	static int f(int x) {
		if (x == 1) return 1;
		else if (x == 2) return 3;
		else {
			if (memo[x] != 0) return memo[x];
			memo[x] = f(x - 1) % mod + 2 * f(x - 2) % mod;
			return memo[x];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		memo = new int[N+1];
		System.out.println(f(N) % mod);
	}
}
