import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		
		for (int i = 0; i < a; i++) {
			int b, c;
			b = scanner1.nextInt();
			c = scanner1.nextInt();
			System.out.println(b + c);
		}

		
	}
}