import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int start = 1;
			while (start < B) start *= 2;
			
			int[] tree = new int[start * 2];
			
			for (int i = 0; i < P + Q; i++) {
				st = new StringTokenizer(br.readLine());
				
				String query = st.nextToken();
				
				if (query.equals("P")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					a = a + start - 1;
					tree[a] += b;
					a /= 2;
					while (a > 0) {
						tree[a] = tree[a * 2] + tree[a * 2 + 1];
						a /= 2;
					}
				}
				else {
					int L = Integer.parseInt(st.nextToken());
					int R = Integer.parseInt(st.nextToken());
					int S = L + start - 1;
					int E = R + start - 1;
					int result = 0;
					while (S <= E) {
						if (S % 2 == 1) result += tree[S++];
						if (E % 2 == 0) result += tree[E--];
						S /= 2;
						E /= 2;
					}
					sb.append(result).append("\n");
				}
			}			
		}
		System.out.println(sb);
		sb.delete(0, sb.length());
	}
}