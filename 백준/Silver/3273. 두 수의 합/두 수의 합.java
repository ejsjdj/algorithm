import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[X];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < X; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = X - 1;
		int cnt = 0;
		
		while (left < right) {
			int value = arr[left] + arr[right];
			if (value == N) {
				cnt++;
				if (arr[left + 1] == arr[left]) {
					left++;
				}
				else if (arr[right] == arr[right - 1]) {
					right--;
				}
				else {
					left++;
					right--;
				}
			} else if (value < N) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(cnt);
	}
}