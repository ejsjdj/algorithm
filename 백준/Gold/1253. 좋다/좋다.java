import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int len = Integer.parseInt(st.nextToken());
		long[] arr = new long[len];
		int answer = 0;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			long k = arr[i];
			int left = 0;
			int right = len - 1;
			while (left < right) {
				if (k == arr[left] + arr[right]) {
					if (left != i && right != i) {
						answer++;
						break;
					} else if (left == i) {
						left++;
					} else if (right == i) {
						right--;
					}
				} else if (arr[left] + arr[right] < k) {
					left++;
				} else if (arr[left] + arr[right] > k) {
					right--;
				}
			}
		}
		System.out.println(answer);
		bf.close();
	}
}