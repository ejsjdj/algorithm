import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 월곡이가 살아온 날
		int Q = Integer.parseInt(st.nextToken());	// 쿼리의 수
		
		int start = 1;
		while (start < N) start *= 2;
		long[] tree = new long[start * 2];
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			
			if (query == 1) {
				int p = Integer.parseInt(st.nextToken());	// 생후 p 일에
				int x = Integer.parseInt(st.nextToken());	// x를 추가한다
				int point = start + p - 1;
				tree[point] += x;
				
				while (point > 0) {
					point /= 2;
					tree[point] = tree[point * 2] + tree[point * 2 + 1];
				}
			}
			
			else if (query == 2) {
				int p = Integer.parseInt(st.nextToken());	// 생후 p일부터 
				int q = Integer.parseInt(st.nextToken());	// q일까지 변화한 양을 출력한다.
				
				int start_index = start + Math.min(p, q) - 1;
				int end_index = start + Math.max(p, q) - 1; 
				long result = 0;
				while (start_index <= end_index) {
					if (start_index % 2 == 1) result += tree[start_index++];
					if (end_index % 2 == 0) result += tree[end_index--];
					start_index /= 2;
					end_index /= 2;
				}
				System.out.println(result);
			}
		}
	}
}