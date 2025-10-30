import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static int[][] arr;
	static int N;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr = new int[N][N];
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
			DFS(0, 0);
		
		System.out.println(result);
	}
	
	static void DFS(int level, int idx) {
		if (level == N / 2) {
			cal();
			return;
		} else {
			for (int i = idx; i < N; i++) {
				visited[i] = true;
				DFS(level + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	static void cal() {
		
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += arr[i][j];
					start += arr[j][i];
				}
				else if (!visited[i] && !visited[j])	{
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		result = Math.min(result, Math.abs(start - link));
		
	}
}