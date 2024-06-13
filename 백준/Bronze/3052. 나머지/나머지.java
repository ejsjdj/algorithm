import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt() % 42;
		}
		Arrays.sort(arr);
		int counter = 1;
		for(int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) {
				counter += 1;
			}
		}
		System.out.println(counter);

	}
}