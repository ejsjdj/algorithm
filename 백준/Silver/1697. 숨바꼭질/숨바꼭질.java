import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int index;
	int step;
	@Override
	public int compareTo(Edge o) {
		return this.step - o.step;
	}
	public Edge(int index, int step) {
		this.index = index;
		this.step = step;
	}
}

public class Main {
	static int K;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] result = new int[100001];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[N] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(N, 0));
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int idx = now.index;
			int step = now.step;
			
			if (idx - 1 >= 0 && result[idx - 1] > step + 1) {
				result[idx - 1] = step + 1;
				pq.add(new Edge(idx - 1, result[idx - 1]));
			}
			if (idx + 1 <= 100000 && result[idx + 1] > step + 1) {
				result[idx + 1] = step + 1;
				pq.add(new Edge(idx + 1, result[idx + 1]));
			}
			if (idx * 2 <= 100000 && result[idx * 2] > step) {
				result[idx * 2] = step + 1;
				pq.add(new Edge(idx * 2, result[idx * 2]));
			}
			
		}
		System.out.println(result[K]);
	}

}