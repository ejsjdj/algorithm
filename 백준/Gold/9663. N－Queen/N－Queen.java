import java.util.Scanner;

public class Main {
	
	static int N;
	static int cnt;
	static int[] arr;
	
	static void nqueens(int row, int col) {
		
		if (isPromising(row, col)) {
			if (row == N - 1) cnt++;
			else {
				for (int i = 0; i < N; i++) {
					arr[row + 1] = i;
					nqueens(row + 1, i);
				}
			}
		}
	}
	
	
	static boolean isPromising(int row, int col) {
		boolean flag = true;
		int k = 0;
		while (k < row && flag) {
			if (arr[row] == arr[k] || Math.abs(arr[k] - arr[row]) == Math.abs(k - row)) {
				flag = false;
			}
			k++;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[0] = i;
			nqueens(0, i);
		}
		
		System.out.println(cnt);
		sc.close();
	}
	
}