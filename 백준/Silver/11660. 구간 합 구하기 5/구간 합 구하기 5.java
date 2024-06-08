import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int sNum = Integer.parseInt(stringTokenizer.nextToken());
		int qNum = Integer.parseInt(stringTokenizer.nextToken());
		
		int[][] S = new int[sNum + 1][sNum + 1];
		
		for (int i = 1; i <= sNum; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= sNum; j++) {
				S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int i = 0; i < qNum; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
		}
	}
}