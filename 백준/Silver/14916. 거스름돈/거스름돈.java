import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0; // 동전의 개수
		
		int N = sc.nextInt();
		
		int fiveWon = N / 5;
		int remain = N % 5;
		
		if (remain % 2 == 0) {
			System.out.println(fiveWon + remain / 2);
		} else {
			if (fiveWon > 0) {
				fiveWon--;
				remain += 5;
				if (remain % 2 == 0) {
					System.out.println(fiveWon + remain / 2);
				} else {
					System.out.println(-1);
				}
			} else {
				if (remain % 2 == 0) {
					System.out.println(remain / 2);
				} else {
					System.out.println(-1);
				}
			}
		}
		
		
		sc.close();
		
	}
}