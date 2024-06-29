import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(bf.readLine());
			list.add(coin);
		}
		
		bf.close();
		
		while (money > 0) {
			for (int i = list.size()-1; i >= 0; i--) {
				if (list.get(i) <= money) {
					int now = list.get(i);
					money -= now;
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}