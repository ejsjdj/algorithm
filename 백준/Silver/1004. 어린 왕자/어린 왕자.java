import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int x3 = Integer.parseInt(st.nextToken());
				int y3 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				if (Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2) < r*r && Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2) < r*r) {
					continue;
				} else if (Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2) < r*r) {
					cnt += 1;
				} else if (Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2) < r*r) {
					cnt += 1;
				} else {
					continue;
				}
			}

			System.out.println(cnt);
		}
	}
}