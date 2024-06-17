import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] A;
	static int[][] answer;
	static boolean[][] visited;
	static int[] combination_x = { -1, 0, 1, 0 };
	static int[] combination_y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		A = new int[M][N];
		for (int i = 0; i < M; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}

		answer = new int[M][N];
		answer[0][0] = 1;
		visited = new boolean[M][N];

		BFS(M, N);
		System.out.println(answer[M - 1][N - 1]);
	}

	private static void BFS(int M, int N) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			int[] L = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = L[0];
				x += combination_x[i];
				int y = L[1];
				y += combination_y[i];
				if (0 <= x && x < M && 0 <= y && y < N && !visited[x][y] && A[x][y] == 1) {
					visited[x][y] = true;
					answer[x][y] = answer[L[0]][L[1]] + 1;
					queue.add(new int[] { x, y });
				}
			}
		}
	}
}