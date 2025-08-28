import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;
	static int size;
	static int cnt;
	static int DES() {
		size = 0;
		cnt = 0;

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					int now_size = 1;
					cnt++;
					visited[i][j] = true;
					queue.add(new int[] {i, j});
					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						int x = now[0];
						int y = now[1];
						if (x + 1 < n && !visited[x + 1][y] && arr[x + 1][y] == 1) {
							visited[x + 1][y] = true;
							queue.add(new int[] {x + 1, y});
							now_size++;
						}
						if (y + 1 < m && !visited[x][y + 1] && arr[x][y + 1] == 1) {
							visited[x][y + 1] = true;
							queue.add(new int[] {x, y + 1});
							now_size++;
						}
						if (x - 1 >= 0 && !visited[x - 1][y] && arr[x - 1][y] == 1) {
							visited[x - 1][y] = true;
							queue.add(new int[] {x - 1, y});
							now_size++;
						}
						if (y - 1 >= 0 && !visited[x][y - 1] && arr[x][y - 1] == 1) {
							visited[x][y - 1] = true;
							queue.add(new int[] {x, y - 1});
							now_size++;
						}
					}
					if (size < now_size) size = now_size;
				}
			}
		}
		
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(DES());
		System.out.println(size);
	}
}