import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int r = sc.nextInt();
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = 0;
			}
			combination(n,r,arr);
			int result = 1;
			for (int j = 0; j < n; j++) {
				if (arr[j] != 0) result *= Math.pow(j+1, arr[j]);
			}
			System.out.println(result);
		}
		sc.close();
	}
	static int[] combination(int n, int r, int arr[]) {
		if (n - r < r) r = n - r;
		while (r != 0) {
			int target_num = n;
			while (target_num != 1) {
				int divide = 2;
				while (true) {
					if (target_num % divide == 0) {
						target_num = target_num / divide;
						arr[divide - 1] += 1;
						break;
					}
					divide += 1;
				}
			}
			
			target_num = r;
			while (target_num != 1) {
				int divide = 2;
				while (true) {
					if (target_num % divide == 0) {
						target_num = target_num / divide;
						arr[divide - 1] -= 1;
						break;
					}
					divide += 1;
				}
			}
			r -= 1;
			n -= 1;
		}
		return arr;
	}
}