import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		int b = scanner1.nextInt();
		
		int t1 = b % 10;
		int t2 = (b - t1) % 100 / 10;
		int t3 = (b - t1- t2) / 100;
		System.out.println(a * t1);
		System.out.println(a * t2);
		System.out.println(a * t3);
		System.out.println(a * b);
	}
}
