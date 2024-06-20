import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int n;	// 해당 객체의 노드번호
	int d;	// 해당 거리
	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
}

public class Main {
	static boolean[] visited;
	static int[] distance;
	static ArrayList< Node>[] A;	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 트리 정점의 개수
		
		A = new ArrayList[N + 1];
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList< Node>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			int now = Integer.parseInt(st.nextToken());
			while (true) {
				int conn = Integer.parseInt(st.nextToken());
				if (conn == -1) break;
				int dis = Integer.parseInt(st.nextToken());
				A[now].add(new Node(conn, dis));
			}
		}
		
		BFS(1);
		
		int max = 1;
		for (int i = 2; i <= N; i++) {
			if (distance[max] < distance[i]) max = i;
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
	
	static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			visited[now] = true;
			for (Node node : A[now]) {
				int n = node.n;
				int d = node.d;
				if (!visited[n]) {
					queue.add(n);
					distance[n] = distance[now] + d;
				}
			}
		}
	}
}