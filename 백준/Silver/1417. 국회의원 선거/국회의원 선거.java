import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int dasom = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		while (true && !pq.isEmpty()) {
			int max = pq.poll();
			if (max >= dasom) {
				max--;
				dasom++;
				cnt++;
				pq.add(max);
			} else {
				break;
			}
		}
		
		System.out.println(cnt);
		
	}

}