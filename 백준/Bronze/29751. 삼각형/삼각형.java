import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		double c = a * b / 2;
		
		System.out.printf("%.1f", c);
		
		sc.close();
		
	}
}