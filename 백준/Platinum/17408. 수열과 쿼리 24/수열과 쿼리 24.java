import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int start = 1;
		
		while (start < N) start *= 2;
		long[][] tree = new long[start * 2][2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) tree[start + i][0] = Integer.parseInt(st.nextToken());
		
		for (int i = start - 1; i > 0; i--) {
			long[] result = find(tree[i * 2], tree[i * 2 + 1]);
			tree[i][0] = result[0];
			tree[i][1] = result[1];
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (i == 1) {
				int point = a + start - 1;
				tree[point][0] = b;
				while (point > 0) {
					point /= 2;
					long[] result = find(tree[point * 2], tree[point * 2 + 1]);
					tree[point][0] = result[0];
					tree[point][1] = result[1];
				}
				
			}
			
			if (i == 2) {
				int start_index = Math.min(a, b) + start - 1;
				int end_index = Math.max(a, b) + start - 1;
				long[] answer = {0, 0};
				while (start_index <= end_index) {
					if (start_index % 2 == 1) {
						long[] result = find(answer, tree[start_index++]);
						answer[0] = result[0];
						answer[1] = result[1];
					}
					if (end_index % 2 == 0) {
						long[] result = find(answer, tree[end_index--]);
						answer[0] = result[0];
						answer[1] = result[1];
					}
					start_index /= 2;
					end_index /= 2;
				}
				System.out.println(answer[0] + answer[1]);
			}
		}
	}
	
	static long[] find(long[] arr1, long[] arr2) {
		long max = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		
		for (long i : arr1) {
			if (i >= max) {
				second = max;
				max = i;
			} 
			else if (i > second) {
				second = i;
			}
		}
		
		for (long i : arr2) {
			if (i >= max) {
				second = max;
				max = i;
			} else if (i > second) {
				second = i;
			}
		}
		return new long[] {max, second};
	}
}