import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); /* 실행횟수 */
		
		boolean arr[][] = new boolean[101][101]; /* 도화지 */
		
		for (int i = 0 ; i < n; i++) {
			int x, y; /* 색종이의 왼쪽 아래 꼭지점의 좌표 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y+10; j++) {
				for (int k = x; k < x+10; k++) {
					arr[k][j] = true;
				}
			}
		}
		
		int cnt = 0; /* 카운터 */
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[j][i] == true) cnt += 1;
			}
		}
		System.out.println(cnt);
		br.close();	
	}
}