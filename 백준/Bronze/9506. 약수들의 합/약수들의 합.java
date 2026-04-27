import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int N = sc.nextInt();
			StringBuilder sb= new StringBuilder();
			int sum = 1;
			if (N == -1) break;
			sb.append(N + " = 1");
			
			for (int i = 2; i <= N/2; i++) {
				if (N % i == 0) {
					sum += i;
					sb.append(" + " + i);
				}
			}
			if (sum == N) {
				System.out.println(sb);
			} else {
				System.out.println(N + " is NOT perfect.");
			}
		}
	}
}