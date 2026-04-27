import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextInt();
		double b = sc.nextInt();
		double c = sc.nextInt();
		double d = sc.nextInt();
		double e = sc.nextInt();
		double f = sc.nextInt();
		
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if (a*x+b*y == c && d*x + e*y == f) {
					System.out.println(x + " "+ y);
					break;
				}
			}
		}
		sc.close();
	}

}
