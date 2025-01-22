import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스의 수
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
			int N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
			int[][] cabbage = new int[N][M];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());	// 배추의 x 좌표
				int b = Integer.parseInt(st.nextToken());	// 배추의 y 좌표
				
				cabbage[b][a] = 1;
			}
			
			System.out.println(cabbageWorm(cabbage));
		}
	}
	
	static int cabbageWorm (int[][] cabbage) {
		
		int result = 0;
		
		for (int i = 0; i < cabbage.length; i++) {
			for (int j = 0; j < cabbage[i].length; j++) {
				if (cabbage[i][j] == 1) {
					result += 1;
					BES(j, i, cabbage);
				}
			}
		}
		
		return result;
	}
	
	static void BES (int x, int y, int[][] cabbage) {
		int[] moveX = {0, 0, -1, 1};
		int[] moveY = {-1, 1, 0, 0};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + moveX[i];
			int ny = y + moveY[i];
			if (0 <= nx && nx < cabbage[0].length &&
				0 <= ny && ny < cabbage.length &&
				cabbage[ny][nx] == 1) {
				cabbage[ny][nx] = 0;
				BES (nx, ny, cabbage);
			}
		}
	}
}