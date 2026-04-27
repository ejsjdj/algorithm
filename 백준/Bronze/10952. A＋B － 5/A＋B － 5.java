import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in); // 스캐너 객체 생성
		int a = scanner1.nextInt(); //최초입력 
		int b = scanner1.nextInt(); //두번째 입력
		while (a != 0 && b != 0) {
			System.out.println(a + b);
			a = scanner1.nextInt();
			b = scanner1.nextInt();
		}
	}
}
