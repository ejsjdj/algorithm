import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			if (d(i) == true) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean d(int input) {
		int primero = 0;
		int segundo = 0;
		while (primero == segundo) {
			if (input < 100) {
				return true;
			}
			if (input >= 100) {
				int right = input % 10;
				int left = input / 10 % 10;
				primero = right - left;
				input = input / 10;
				right = input % 10;
				left = input / 10 % 10;
				segundo = right - left;
				if (primero != segundo) {
					return false;
				}
			}
		}
		return false;
	}
}