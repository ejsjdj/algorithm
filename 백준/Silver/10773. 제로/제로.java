import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int a = 0;
		LinkedList<Integer> list = new LinkedList<>();
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
			a = sc.nextInt();
			if (a == 0) {
				sum -= list.removeLast();
			} else {
				sum += a;
				list.add(a);
			}
		}
		System.out.println(sum);

	}

}
