import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				set.add(i);
				set.add(j);
				set.add(i*j);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		System.out.println(set.contains(input) ? 1 : 0);
		
		sc.close();
		
	}
}