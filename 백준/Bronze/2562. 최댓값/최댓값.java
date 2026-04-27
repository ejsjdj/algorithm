import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in); // 스캐너 객체 생성
		
		int maxNumber = 0;
		int otherNumber = 0;
		int maxNumberCount = 0;
		for (int i = 0; i < 9; i++) {
			otherNumber = scanner1.nextInt();
			if (maxNumber < otherNumber) {
				maxNumber = otherNumber;
				maxNumberCount = i + 1;
			}
		}
		System.out.println(maxNumber);
		System.out.println(maxNumberCount);
	}
}
