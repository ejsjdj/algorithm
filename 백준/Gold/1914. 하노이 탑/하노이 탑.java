import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	static void hanoi(int N, int start, int mid, int end) {
		if (N == 1) {
			System.out.println(start + " " + end);
		} else {
			hanoi(N - 1, start, end, mid);
			System.out.println(start + " " + end);
			hanoi(N - 1, mid, start, end);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
		if (N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		sc.close();
	}
}