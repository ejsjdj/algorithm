import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in); // 스캐너 객체 생성
		int arrayNumber = scanner1.nextInt();
		int array[] = new int[arrayNumber];
		
		for(int i = 0; i < arrayNumber; i++) {
			array[i] = scanner1.nextInt();
		}
		
		Arrays.sort(array);
		System.out.println(array[0] + " " + array[arrayNumber - 1]);
	}
}
