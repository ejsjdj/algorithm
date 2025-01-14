import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken()); // column 크기
		int M = Integer.parseInt(st.nextToken()); // row 크기
		
		int[][] city = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		boolean[][] visited = new boolean[M][N];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		
		boolean flag = false;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			if (pos[0] == M - 1 && pos[1] == N - 1) {
				flag = true;
				break;
			}
			
			for (int i = 0; i < 2; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				if (nx < M && ny < N && !visited[nx][ny] && city[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		if (flag) System.out.println("Yes");
		else System.out.println("No");
	}
}