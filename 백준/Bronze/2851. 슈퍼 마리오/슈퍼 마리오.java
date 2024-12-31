import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sum = new int[11];

		for (int i = 1; i <= 10; i++) {
			sum[i] = sum[i - 1] + sc.nextInt();
			if (sum[i] > 100) {
				if (sum[i] - 100 > 100 - sum[i - 1]) {
					System.out.println(sum[i - 1]);
					break;
				} else {
					System.out.println(sum[i]);
					break;
				}
			}
			if (i == 10) System.out.println(sum[10]);
		}
		sc.close();
	}
}