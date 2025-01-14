import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 행의 수
		int M = Integer.parseInt(st.nextToken());	// 열의 수
		
		int[][] seats = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				seats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		int column = Integer.parseInt(st.nextToken()); 
		
		int maxScore = 0;
		int score = 0;
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < N; j++) {
				maxScore += seats[j][i];
			}
		}
		score = maxScore;
		for (int i = 0; i < M - column; i++) {
			for (int j = 0; j < N; j++) {
				score -= seats[j][i];
				score += seats[j][i + column];
			}
			if (maxScore < score) maxScore = score;
		}
		
		System.out.println(maxScore);
	}
}