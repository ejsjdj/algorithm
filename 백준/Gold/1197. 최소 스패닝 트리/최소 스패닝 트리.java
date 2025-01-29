import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a, b, weight));
		}
		
		int useEdge = 0;
		int result = 0;
		while (useEdge < V - 1) {
			Edge now = pq.poll();
			if (find(now.a) != find(now.b)) {
				union(now.a, now.b);
				result += now.weight;
				useEdge++;
			}
		}
		System.out.println(result);
	}
	
	static void union (int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parents[b] = a;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
}

class Edge implements Comparable<Edge>{
	int a;
	int b;
	int weight;
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	public Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
}