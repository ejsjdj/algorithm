import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		sc.close();
		for (int i = 1; i < 100000; i++) {
			if (d(i) >= input) {
				System.out.println(i);
				break;
			}
		}
		
	}
	public static int d(int num) {
		return 3 * num * num - 3 * num + 1;
	}
}