import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max_weight = sc.nextInt();
		
		int bag[] = new int[max_weight+1];
		for (int i = 0; i < N; i ++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			for (int j = max_weight - weight; j >= 0; j--) {
				if (bag[weight + j] < bag[j] + value) {
					bag[weight + j] = bag[j] + value;
				}
			}
		}
		Arrays.parallelSort(bag);
		System.out.print(bag[max_weight]);
	}
}