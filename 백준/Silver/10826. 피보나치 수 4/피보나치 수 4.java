import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger left = BigInteger.ZERO;
		BigInteger right = BigInteger.ONE;
		BigInteger result = BigInteger.ZERO;
		if (N == 0) System.out.println(left);
		else if (N == 1) System.out.println(right);
		else {
			for (int i = 2; i <= N; i++) {		
				result = left.add(right);
				left = right;
				right = result;
			}
		}
		if (N > 1) System.out.println(result); // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
		sc.close();
	}
}