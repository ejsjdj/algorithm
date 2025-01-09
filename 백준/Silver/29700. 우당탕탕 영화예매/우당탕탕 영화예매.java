import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M - K + 1; j++) {
				String pos = str.substring(j, j+K);
				boolean flag = true;
				for (int l = 0; l < K; l++) {
					if (pos.charAt(l) != '0') {
						flag = false;
						break;
					}
				}
				if (flag) cnt++;
			}
		}
		System.out.println(cnt);
		bf.close();
	}
}