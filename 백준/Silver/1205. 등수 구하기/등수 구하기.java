import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Long taesu = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		
		int pos = 1;
		int cnt = 0;
		
		
		if (N != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				long num = Long.parseLong(st.nextToken());
				if (num >= taesu) pos++;
				if (num == taesu) cnt--;
			}			
		}
		
		if (pos > P) System.out.println(-1);
		else System.out.println(pos + cnt);
		
	}
}