import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 가수의 수
		int K = Integer.parseInt(st.nextToken());	// PD의 수
		
		int[] singers =  new int[N + 1];
		List<PriorityQueue<Integer>> list = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
			list.add(new PriorityQueue<>());
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int next = 0;
			int last = -1;  
			for (int j = 0; j < length; j++) {
			    next = Integer.parseInt(st.nextToken());
			    if (j > 0) {  
			        singers[next]++;
			        list.get(last).add(next);
			    }
			    last = next;
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			if (singers[i] == 0) pq.add(i);
		}
		Queue<Integer> queue = new LinkedList<>();
		while (!pq.isEmpty()) {
			int now = pq.poll();
			queue.add(now);
			while (!list.get(now).isEmpty()) {
				int next = list.get(now).poll();
				singers[next]--;
				if (singers[next] == 0) pq.add(next);
			}
		}
		
		if (queue.size() == N) {
			StringBuilder sb = new StringBuilder();
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append("\n");
			}
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
	}
}