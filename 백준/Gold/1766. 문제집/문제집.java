import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 문제의 개수
		int K = Integer.parseInt(st.nextToken()); // 조건의 개수
		
		int[] question = new int[N + 1];
		
		List<PriorityQueue<Integer>> link = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i ++) {
			link.add(new PriorityQueue<>());
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int preority = Integer.parseInt(st.nextToken());
			int postiority = Integer.parseInt(st.nextToken());
			question[postiority]++;
			link.get(preority).add(postiority);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = N; i > 0; i--) {
			if (question[i] == 0) pq.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int now = pq.poll();
			
			while (!link.get(now).isEmpty()) {
				int i = link.get(now).poll();
				question[i]--;
				if (question[i] == 0) pq.add(i);
			}
			
			sb.append(now).append(" ");
		}
		System.out.println(sb);
	}
}