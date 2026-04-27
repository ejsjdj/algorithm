import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		for ( int i = 1; i <= a; i++ ) {
			for ( int j = a - i; j > 0; j -- ) {
				System.out.print(" ");
			}
			for ( int k = 1; k <= i; k++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
