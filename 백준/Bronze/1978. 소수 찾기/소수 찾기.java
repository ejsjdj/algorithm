import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int cnt = 0;
		
		for (int i = 0; i < T; i++) {
			int num = sc.nextInt();
			if (d(num) == true) {
				cnt += 1;
			}
			
			
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static boolean d(int num) {
		if (num == 1) {
			return false;
		}
		
		else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}