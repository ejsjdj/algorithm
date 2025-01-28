import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, M;
	static int distance[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());	// 도시의 수
		M = Integer.parseInt(br.readLine());	// 버스의 수
		distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) 
					distance[i][j] = 0;
				else distance[i][j] = 10000001;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (distance[s][e] > v) distance[s][e] = v;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distance[i][j] == 10000001) System.out.print("0 ");
				else System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}
}
