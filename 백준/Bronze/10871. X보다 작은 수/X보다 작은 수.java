import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int arrayNumber = scanner1.nextInt(); //수열의 수
		
		int indexNumber = scanner1.nextInt(); //기준이 되는 수 해당 수 보다 작은 수를 구해야 함
		
		for (int i = 0; i < arrayNumber; i++) {
			int inputNumber = scanner1.nextInt();
			if (inputNumber < indexNumber) {
				System.out.print(inputNumber + " ");
			}
		}

	}
}
