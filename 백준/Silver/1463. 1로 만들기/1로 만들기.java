import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (i % 6 == 0) {
				arr[i] = Math.min(arr[i/2], Math.min(arr[i/3], arr[i-1])) + 1;
			} else if (i % 3 == 0) {
				arr[i] = Math.min(arr[i/3], arr[i-1]) + 1;
			} else if (i % 2 == 0) {
				arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
			} else if (i == 0 || i == 1){
				arr[i] = 0;
			} else {
				arr[i] = arr[i-1] + 1;			
			}
		}
		System.out.println(arr[N]);
	}
}