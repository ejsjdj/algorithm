import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if (N == 0) { System.out.println(1); }
		else {
			long result = 1;
			for (int i = 1; i <= N; i++) { result *= i; }
			System.out.println(result);			
		}
		sc.close();
	}
}
