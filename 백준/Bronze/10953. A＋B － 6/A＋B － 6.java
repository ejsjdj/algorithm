import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			System.out.println(a+b);
		}
		sc.close();
	}
}
