import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr;
		
		arr = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = 1;
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
					arr[j][2] += 1;
					
				} else {
					continue;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i][2] + " ");
		}
	}
}