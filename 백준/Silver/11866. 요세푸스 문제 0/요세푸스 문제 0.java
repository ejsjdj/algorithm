import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = K - 1;
		LinkedList<Integer> result = new LinkedList<>();
		while (!list.isEmpty()) {
			idx %= list.size();
			result.add(list.remove(idx));
			idx += K-1;
		}
		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i < result.size() - 1) System.out.print(", ");
			else System.out.println(">");
		}
	}
}