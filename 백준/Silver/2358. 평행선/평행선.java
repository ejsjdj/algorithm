import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int cnt = 0;
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		
		HashMap<Integer, Integer> xhm = new HashMap<>();
		HashMap<Integer, Integer> yhm = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			xhm.put(x, xhm.getOrDefault(x, 0) + 1);
			yhm.put(y, yhm.getOrDefault(y, 0) + 1);
			
		}
		
		for (int i : xhm.values()) {
			if (i > 1) cnt++;
		}
		for (int i : yhm.values()) {
			if (i > 1) cnt++;
		}
		
		System.out.println(cnt);
	}
}