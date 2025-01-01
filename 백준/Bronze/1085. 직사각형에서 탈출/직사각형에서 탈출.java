import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = w - x;
		int q = h - y;
		
		if (x > p) {
			x = p;
		}
		if (y > q) {
			y = q;
		}
		if (x < y) {
			System.out.println(x);
		} else {
			System.out.println(y);
		}
	}
}