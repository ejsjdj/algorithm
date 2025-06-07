import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	boolean visited = false;
	PriorityQueue<Integer> link = new PriorityQueue<>();
	int turn;
}

public class Main {
	static int cnt = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		Edge[] edge = new Edge[N + 1];
		for (int i = 0; i <= N; i++) {
			edge[i] = new Edge();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			edge[left].link.add(right);
			edge[right].link.add(left);
		}
		DFS(edge, R);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < edge.length; i++) {
			sb.append(edge[i].turn).append("\n");
		}
		System.out.println(sb);
	}
	
	static void DFS (Edge[] edge, int E) {
		if (!edge[E].visited) {
			edge[E].visited = true;
			edge[E].turn = cnt++;
			while (!edge[E].link.isEmpty()) {
				int now = edge[E].link.poll();
				DFS(edge, now);
			}
		}
	}
}