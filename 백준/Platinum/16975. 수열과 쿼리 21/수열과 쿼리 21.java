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
		long[] tree = new long[start * 2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[start + i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			
			if (q == 1) {
				int start_index = Integer.parseInt(st.nextToken()) + start - 1;
				int end_index = Integer.parseInt(st.nextToken()) + start - 1;
				int x = Integer.parseInt(st.nextToken());
				
				while (start_index <= end_index) {
					if (start_index % 2 == 1) tree[start_index++] += x;
					if (end_index % 2 == 0) tree[end_index--] += x;
					start_index /= 2;
					end_index /= 2;
				}
			}
			
			else if (q == 2) {
				int x = Integer.parseInt(st.nextToken()) + start - 1;
				long result = 0;
				while (x > 0) {
					result += tree[x];
					x /= 2;
				}
				System.out.println(result);
			}
		}
	}
}