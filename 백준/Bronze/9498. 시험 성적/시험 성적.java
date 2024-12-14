import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int a = scanner1.nextInt();
		int b = a / 10;
		
		switch (b) {
		case 10 :
			System.out.println("A");
			break;
		case 9 :
			System.out.println("A");
			break;
		case 8 : 
			System.out.println("B");
			break;
		case 7 :
			System.out.println("C");
			break;
		case 6 :
			System.out.println("D");
			break;
		default :
			System.out.println("F");
			break;
		}
	}
}