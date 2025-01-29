import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 친구관계의수
		
		int[][] people = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				people[i][j] = 10000001;
				if (i == j) people[i][j] = 0;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			people[a][b] = 1;
			people[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					people[i][j] = Math.min(people[i][j], people[i][k] + people[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int answer = -1;
		for (int i = 1; i <= N; i++) {
			int value = 0;
			for (int j = 1; j <= N; j++) {
				value += people[i][j];
			}
			if (min > value) {
				min = value;
				answer = i;
			}
		}
		System.out.println(answer);
	}
}