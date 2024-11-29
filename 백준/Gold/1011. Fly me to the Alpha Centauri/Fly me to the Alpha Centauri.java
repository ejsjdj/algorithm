import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int distance = -(sc.nextInt() - sc.nextInt());
			
			int max = (int) Math.sqrt(distance);
			
			if (max * max == distance) {
				System.out.println(2 * max - 1);
			} else if (distance - max * max <= max) {
				System.out.println(2 * max);
			} else {
				System.out.println(2 * max + 1);
			}
		}
	}
}