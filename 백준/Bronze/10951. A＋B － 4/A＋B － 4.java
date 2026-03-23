import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in); // 스캐너 객체 생성
		while(scanner1.hasNext()) {
			int a = scanner1.nextInt(); //최초입력 
			int b = scanner1.nextInt(); //두번째 입력
			System.out.println(a + b);
		}
	}
}
