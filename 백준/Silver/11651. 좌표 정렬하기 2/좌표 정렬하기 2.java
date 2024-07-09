import java.util.Arrays;
import java.util.Scanner;

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Point[] arr = new Point[N];
		
		for (int i = 0; i < N; i++) {
			String[] strArr = sc.nextLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			
			arr[i] = new Point(a, b);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.y - o2.y > 0) return 1;
			else if (o1.y == o2.y) {
				if (o1.x - o2.x > 0) return 1;
			}
			return -1;
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i].x + " " + arr[i].y);
		}
		sc.close();
	}
}