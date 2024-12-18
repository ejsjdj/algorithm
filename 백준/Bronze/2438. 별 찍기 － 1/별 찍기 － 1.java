import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		for(int i = 1; i <= a; i ++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
