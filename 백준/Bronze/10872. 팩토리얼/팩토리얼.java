import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(d(sc.nextInt()));
	}
	public static int d (int num) {
		if (num == 1 || num == 0) {
			return 1;
		} else {
			return num * d(num - 1);
		}
	}
}