import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] start;
	static int[][] move = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	static void DES() {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		while (!queue.isEmpty()) {
			
			int[] now = queue.poll();
			for (int[] move : move) {
				int new_x = now[0] + move[0];
				int new_y = now[1] + move[1];
				if (0 <= new_x && new_x < N && 0 <= new_y && new_y < M && !visited[new_x][new_y] && arr[new_x][new_y] == -1) {
					queue.add(new int[] {new_x, new_y});
					visited[new_x][new_y] = true;
					arr[new_x][new_y] = arr[now[0]][now[1]] + 1;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2) {
					start = new int[] {i, j};
					input = 0;
				}
				if (input == 1) input = -1;
				arr[i][j] = input;
			}
		}
		DES();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}