import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static int N;
	static int[][] arr;
	
	static int BES(int level) {
		
		visited = new boolean[N][N];
		int cnt = 0;
		Queue<Integer[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > level && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					queue.add(new Integer[] {i,j});
					while (!queue.isEmpty()) {
						Integer[] now = queue.poll();
						int now_x = now[0];
						int now_y = now[1];
						if (now_x - 1 >= 0 && !visited[now_x-1][now_y] && arr[now_x - 1][now_y] > level) {
							visited[now_x - 1][now_y] = true;
							queue.add(new Integer[] {now_x - 1, now_y});
						}
						if (now_y - 1 >= 0  && !visited[now_x][now_y-1] && arr[now_x][now_y - 1] > level) {
							visited[now_x][now_y - 1] = true;
							queue.add(new Integer[] {now_x, now_y - 1});
						}
						if (now_x + 1 < N && !visited[now_x+1][now_y] && arr[now_x + 1][now_y] > level) {
							visited[now_x + 1][now_y] = true;
							queue.add(new Integer[] {now_x + 1, now_y});
						}
						if (now_y + 1 < N && !visited[now_x][now_y + 1] && arr[now_x][now_y + 1] > level) {
							visited[now_x][now_y + 1] = true;
							queue.add(new Integer[] {now_x, now_y + 1}); 
						}
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <= 100; i++) {
			cnt = Math.max(cnt, BES(i));
		}
		System.out.println(cnt);
	}
}