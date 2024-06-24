import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 나무의 개수
		int M = sc.nextInt();	// 적어도 목표로 하는 나무의 길이
		
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (end < arr[i]) end = arr[i];
		}
		
		while (start < end) {
			int mid = (start + end) / 2;
			long len = 0;
			
			for (int i = 0; i < arr.length; i++) {
				int cut = arr[i] - mid;
				if (cut > 0) len += cut;
			}
			
			if (len < M) end = mid;
			else {
				start = mid+1;
			}
		}
		System.out.println(start-1);
	}
}