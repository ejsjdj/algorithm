import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			double dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
			
			if (x2 == x1 && y2 == y1 && r2 == r1) {
				System.out.println(-1);
			}
			else if (dis > r2 + r1) {
				System.out.println(0);
			}
			else if (dis < Math.abs(r2 - r1)) {
				System.out.println(0);
			}
			else if (dis == Math.abs(r2 - r1)) {
				System.out.println(1);
			}
			else if (dis == Math.abs(r2 + r1)) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}
		sc.close();
	}
}