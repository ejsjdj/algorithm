import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int index;
    int distance;
    List<Node> neighbor = new ArrayList<>();
    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 노드의 개수
		int M = Integer.parseInt(st.nextToken());	// 알고싶은 노드 쌍의 개수
		int INF = Integer.MAX_VALUE;
		Node[] node = new Node[N + 1];
		
		for (int i = 1; i < node.length; i++) {
			node[i] = new Node(i, INF);
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 노드 사이의 거리
			node[a].neighbor.add(new Node(b, c));
			node[b].neighbor.add(new Node(a, c));
		}
		
		for (int K = 0; K < M; K++) {
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int S = Integer.parseInt(st.nextToken());	// 시작지점
			int E = Integer.parseInt(st.nextToken());	// 종료지점
			for (int i = 1; i <= N; i++) {
				node[i].distance = INF;
			}
			node[S].distance = 0;
			pq.add(node[S]);
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				for (Node neighbor : now.neighbor) {
					if (node[neighbor.index].distance > now.distance + neighbor.distance) {
						node[neighbor.index].distance = now.distance + neighbor.distance;
						pq.add(node[neighbor.index]);
					}
				}
			}
			System.out.println(node[E].distance);
		}
	}
}