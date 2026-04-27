import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(f(sc.nextInt()));
		sc.close();
	}
	public static int f(int num) {
		
		int cnt = 0; // 자릿수 저장
		int numA = num; // 입력 받은 숫자 저장
		
		while (numA != 0) {
			cnt += 1;
			numA = numA / 10;
		}
		
		for (int i = num - (9 * cnt); i < num; i++) {
			int x = 0; //  각 자릿수 합 저장
			int testNum = i;
			for (int j = 0; j < cnt; j++) {
				x += testNum % 10;
				testNum /= 10;
			}
			if (i + x == num) {
				return i;
			}
			
		}
		return 0;
	}
}