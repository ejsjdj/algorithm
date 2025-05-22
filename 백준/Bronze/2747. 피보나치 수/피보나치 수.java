import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long n1 = 0;
		long n2 = 1;
		long n3 = 1;
		for (int i = 2; i <= N; i++) {
			n3 = n2 + n1;
			n1 = n2;
			n2 = n3;
		}
		if (N == 1) System.out.println(1);
		else if (N == 2) System.out.println(1);
		else System.out.println(n3);
		
	}
}