import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int remain;
		int max = 0;;
		int[] arr = new int[10];
		
		
		while (N > 0) {
			remain = N % 10;
			N /= 10;
			arr[remain] += 1;
		}
		
		arr[6] += arr[9];
		arr[9] = 0;
		arr[6] = (arr[6]+1)/2;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) max = arr[i];
		}
		System.out.println(max);
		sc.close();
	}
}