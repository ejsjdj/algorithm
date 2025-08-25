import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][][] arr = new int[N + 1][N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int step = Integer.parseInt(st.nextToken());
				if (i != j && step == 0) step = Integer.MAX_VALUE / 2;
				arr[0][i][j] = step;
			}
		}
		
		for (int mid = 1; mid <= N; mid++) {
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					arr[mid][start][end] = Math.min(arr[mid-1][start][mid] + arr[mid-1][mid][end], arr[mid-1][start][end]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int result = arr[C-1][s][e];
			if (s != e && result == Integer.MAX_VALUE / 2) sb.append(-1);
			else sb.append(arr[C-1][s][e]);
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
}
