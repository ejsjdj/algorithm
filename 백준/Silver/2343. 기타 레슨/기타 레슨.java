import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (start < arr[i]) start = arr[i]; 
			end += arr[i];
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
				if (sum > mid) {
					cnt++;
					sum = arr[i];
				}
			}
			if (sum != 0) cnt++;
			if (cnt > M) start = mid + 1; 
			else end = mid - 1;
		}
		System.out.println(start);
		sc.close();
	}
}