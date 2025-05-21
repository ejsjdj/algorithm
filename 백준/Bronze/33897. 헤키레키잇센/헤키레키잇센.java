import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long skil = 1;
		long max = 1;  // 최소 1개는 반드시 벰
		long cnt = 1;  // 첫 원소부터 시작함
		long last = Long.parseLong(st.nextToken());

		for (int i = 1; i < N; i++) {
			long now = Long.parseLong(st.nextToken());
			if (last <= now) {
				cnt++;
			} else {
				skil++;
				cnt = 1;  // 새롭게 시작
			}
			last = now;
			max = Math.max(max, cnt);
		}
		System.out.println(skil + " " + max);
	}
}