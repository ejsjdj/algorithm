import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 30분 이하 주차시 기본요금 A원
		// 30분 초과 주차지 기본요금 A원 + B분마다 C원이 추가
		// 초과시간이 B원으로 나누어 떨어지지 않으면 올림하여 계산
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();	// 기본요금
		int B = sc.nextInt();	// B분마다
		int C = sc.nextInt();	// C원추가
		int T = sc.nextInt();	// 시간
		
		if (T <= 30) System.out.println(A);
		else {
			T = T - 30;
			if (T % B == 0) {
				System.out.println(A + (T / B) * C);
			} else {
				System.out.println(A + (T / B + 1) * C);
			}
		}
	}
}