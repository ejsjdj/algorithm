import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		sc.close();
		int i = 1;
		while (d(i) < input) {
			i++;
		}
		
		if (input > 1) {
			if (i % 2 == 0) {
				System.out.print(input - d(i - 1));
				System.out.print("/");
				System.out.print(i + 1 - (input - d(i - 1)));
			} else {
				System.out.print(i + 1 - (input - d(i - 1)));
				System.out.print("/");
				System.out.print(input - d(i - 1));
			}
		} else {
			System.out.println(1 + "/" + 1);
		}
	}
	
	public static int d(int num) {
		return (num * num + num) / 2;
	}
}