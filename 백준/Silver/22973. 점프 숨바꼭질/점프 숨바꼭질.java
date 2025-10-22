import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		long num = sc.nextLong();
		
		if (num == 0) {
			System.out.println(0);
			return;
		}
		else if (num % 2 == 0) {
			System.out.println(-1);
			return;
		}
		
		num = Math.abs(num);
		
		int cnt = 0;
		while (num > 0) {
			num >>= 1;
			cnt++;			// 0 1 2 3
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}