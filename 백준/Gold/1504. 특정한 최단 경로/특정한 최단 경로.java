import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	
	int targetNode;	// 연결된 지점
	int value;		// 연결된 지점이로 이동하는 거리
	
	public Edge(int targetNode, int value) {
		this.targetNode = targetNode;
		this.value = value;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.value, o.value);
	}
}

public class Main {

	static int N;
	static int M;
	
	static int INF = 100000000;
	static List<List<Edge>> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			list.get(a).add(new Edge(b, dis));
			list.get(b).add(new Edge(a, dis));
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int startToA = dijkstra(1, a);
		int startToB = dijkstra(1, b);
		int AToB = dijkstra(a, b);		
		int BToA = dijkstra(b, a);
		int AToN = dijkstra(a, N);
		int BToN = dijkstra(b, N);
		
		int result1 = startToA + AToB + BToN;
		int result2 = startToB + BToA + AToN;
		
		if (result1 >= INF) System.out.println(-1);
		else System.out.println(Math.min(result1, result2));
		
	}
	
	static int dijkstra(int start, int end) {
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int currentEdge = now.targetNode;
			int currentValue = now.value;
			
			if (currentValue > dist[currentEdge]) continue;
			
			// 현재 경로보다 더 짧으면 업데이트
			for (Edge neigbor : list.get(currentEdge)) {
				
				int nextEdge = neigbor.targetNode;
				int weight = neigbor.value;
				
				if (dist[currentEdge] + weight < dist[nextEdge]) {
					dist[nextEdge] = dist[currentEdge] + weight;
					pq.offer(new Edge(nextEdge, dist[nextEdge]));
				}
				
			}
			
		}
		
		return dist[end];
		
	}
	
}