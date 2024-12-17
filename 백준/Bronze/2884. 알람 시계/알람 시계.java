import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		int b = scanner1.nextInt();
		
		if (b < 45) {
			if(a < 1) {
				a = 23;
				b = 60 - (45 - b);
				System.out.println(a + " " + b);
			} else {
				a = a - 1;
				b = 60 - (45 - b);
				System.out.println(a + " " + b);
			}
		} else {
			b = b - 45;
			System.out.println(a + " " + b);
		}
	}
}