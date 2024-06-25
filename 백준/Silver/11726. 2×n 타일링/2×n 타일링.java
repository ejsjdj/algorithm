import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int left = 0;
		int right = 1;
		for (int i = 0; i < N; i++) {
			int newN = (left + right)%10007;
			left = right;
			right = newN;
		}
		System.out.println(right);
	}
}