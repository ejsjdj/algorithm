import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		long num = sc.nextLong();
		
		if (num < 0) num = -num;
		
		num += 1;
		int cnt = 0;
		
		while (num != 1) {
			if (num % 2 != 0) {
				System.out.println(-1);
				return;
			} else {
				num /= 2;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}