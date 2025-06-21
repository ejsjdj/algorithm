import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] arr = new boolean[26];
	static boolean[][] visited;
	static int[][] board;
	static int MAX = Integer.MIN_VALUE;
	
	static int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		board = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j) - 'A';
			}
		}
		visited[0][0] = true;
		arr[board[0][0]] = true;
		DFS(0, 0, 1);
		System.out.println(MAX);
	}
	
	static void DFS(int R, int C, int step) {
		MAX = Math.max(step, MAX);
		for (int i = 0; i < move.length; i++) {
			
			int nextR = R + move[i][0];
			int nextC = C + move[i][1];
			if (nextR >= 0 && nextR < board.length &&
				nextC >= 0 && nextC < board[0].length) {
				if (!visited[nextR][nextC] && !arr[board[nextR][nextC]]) {
					visited[nextR][nextC] = true;
					arr[board[nextR][nextC]] = true;
					DFS(nextR, nextC, step + 1);
					visited[nextR][nextC] = false;
					arr[board[nextR][nextC]] = false;
				}
			}
		}
	}
}