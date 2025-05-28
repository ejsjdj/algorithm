import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int sum = Integer.MAX_VALUE;
		
		int leftAnswer = 0;
		int rightAnswer = arr.length - 1;
		while (left != right) {
			if (Math.abs(arr[left] + arr[right]) < sum) {
				leftAnswer = left;
				rightAnswer = right;
				sum = Math.abs(arr[left] + arr[right]);
			}
			if (arr[left] + arr[right] > 0) right--;
			else if (arr[left] + arr[right] < 0) left++;
			else {
				break;
			}
		}
		
		System.out.println(arr[leftAnswer] + " " + arr[rightAnswer]);
		
	}
}