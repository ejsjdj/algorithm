import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		sc.close();
		
		if (x == 0 || y == 0 || z == 0) {
			System.out.println("Error");
		} else if (x + y + z != 180) {
			System.out.println("Error");
		} else if (x == y && y == z) {
			System.out.println("Equilateral");
		} else if (x == y || y == z || z == x) {
			System.out.println("Isosceles");
		} else System.out.println("Scalene");
	}
}
