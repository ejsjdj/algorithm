import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		for(int i = 1; i <= a; i ++) {
			int b = scanner1.nextInt();
			int c = scanner1.nextInt();
			System.out.println("Case #" + i + ": " + b + " + " + c + " = " + (b + c) );
		}
	}
}
