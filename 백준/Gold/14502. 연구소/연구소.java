import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] lab = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(buildWall(lab));
	}
	
	static int buildWall(int[][] lab) {
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if (lab[i][j] != 0) continue;
				lab[i][j] = 1;
				for (int k = 0; k < lab.length; k++) {
					for (int l = 0; l < lab[0].length; l++) {
						if (lab[k][l] != 0) continue;
						lab[k][l] = 1;
						for (int n = 0; n < lab.length; n++) {
							for (int m = 0; m < lab[0].length; m++) {
								if (lab[n][m] != 0) continue;
								lab[n][m] = 1;
								result = Math.max(result, virus(lab));
								lab[n][m] = 0;
							}
						}
						lab[k][l] = 0;
					}
				}
				lab[i][j] = 0;
			}
		}
		return result;
	}
	
	
	static int virus(int[][] lab) {
		int[][] temp = new int[lab.length][lab[0].length];
		
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				temp[i][j] = lab[i][j];
			}
		}
		
		int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[lab.length][lab[0].length];
		
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if (temp[i][j] == 2 && !visited[i][j]) {
					queue.add(new int[] {i, j});
					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						int row = now[0];
						int col = now[1];
						for (int k = 0; k < 4; k++) {
							int m_row = row + move[k][0];
							int m_col = col + move[k][1];
							
							if (0 <= m_row && m_row < lab.length &&
								0 <= m_col && m_col < lab[0].length &&
								!visited[m_row][m_col] && temp[m_row][m_col] == 0) {
								visited[m_row][m_col] = true;
								temp[m_row][m_col] = 2;
								queue.add(new int[] {m_row, m_col});
							}
						}
					}
				}
			}
		}
		
		return safeZoneCounter(temp);
		
	}
	
	static int safeZoneCounter(int[][] lab) {
		int result = 0;
		
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if (lab[i][j] == 0) result++;
			}
		}
		
		return result;
		
	}
}