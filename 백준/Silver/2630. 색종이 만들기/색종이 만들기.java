import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cntBlue;
	static int cntWhite;
	static int N;
	static boolean[][] arr;
	
	static void colorPaper(int y, int y1, int x, int x1) {
		
		boolean flag = false;
		boolean stan = arr[y][x];	// true 일때는 블루 false 일때는 화이트
		
		for (int i = y; i <= y1; i++) {
			for (int j = x; j <= x1; j++) {
				if (stan != arr[i][j]) {	// 기준점이랑 다르면
					flag = true;			// 다를시 flag 를 트루로 바꿈
					break;
				}
			}
			if (flag) break;
		}
		
		int midX = (x + x1) / 2; 
		int midY = (y + y1) / 2; 
		
		if (flag) {	// 다를 경우 분기
			
			// 왼쪽 위
			colorPaper(y, midY, x, midX);
			// 오른쪽 위
			colorPaper(y, midY, midX + 1, x1);
			// 왼쪽 아래
			colorPaper(midY + 1, y1, x, midX);
			// 오른쪽 아래
			colorPaper(midY + 1, y1, midX + 1, x1);
			
		} else {	// 같을 경우 카운트를 함
			if (stan) cntBlue += 1;
			else cntWhite += 1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		cntBlue = 0;
		cntWhite = 0;
		N = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		
		colorPaper(1, N, 1, N);
		System.out.println(cntWhite);
		System.out.println(cntBlue);
	}
}