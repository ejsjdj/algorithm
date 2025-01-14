import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int left_size = Integer.parseInt(st.nextToken());
			int right_size = Integer.parseInt(st.nextToken());
			
			Integer[] left = new Integer[left_size];
			Integer[] right = new Integer[right_size];
			int answer = 0;
			
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < left_size; j++) {
				left[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(left, Collections.reverseOrder());
			
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < right_size; j++) {
				right[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(right, Collections.reverseOrder());
			
			int left_pointer = 0;
			int right_pointer = 0;
			
			while (right_pointer < right_size && left_pointer < left_size) {
				if (left[left_pointer] <= right[right_pointer]) {
					right_pointer++;
				} else if (left[left_pointer] > right[right_pointer]) {
					answer += right_size - right_pointer;
					left_pointer++;
				}
			}
			System.out.println(answer);
		}
		
	}
}