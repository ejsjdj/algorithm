import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			int input = sc.nextInt();
			sum += input;
			list.add(input);
		}
		Collections.sort(list);
		System.out.println(sum/5);
		System.out.println(list.get(2));
		
		sc.close();
	}
}