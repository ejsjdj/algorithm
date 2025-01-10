import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] table = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			table[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int maxCount = 0;
		int cnt = 0;
		
		for (int i = 0; i < k; i++) {
			int value = table[i];
			hm.put(value, hm.getOrDefault(value, 0) + 1);
			if (hm.get(value) == 1) cnt++;
			maxCount = cnt > maxCount ? cnt : maxCount;
		}
		
		for (int i = 0; i < N; i++) {
			int value = table[(i + k) % N];
			hm.put(value, hm.getOrDefault(value, 0) + 1);
			if (hm.get(value) == 1) cnt++;
			
			value = table[i];
			hm.put(value, hm.get(value) - 1);
			if (hm.get(value) == 0) {
				cnt--;
				hm.remove(value);
			}
			
			maxCount = Math.max(maxCount, hm.getOrDefault(c, 0) == 0 ? cnt + 1 : cnt);
		}
		
		System.out.println(maxCount);
	}
}