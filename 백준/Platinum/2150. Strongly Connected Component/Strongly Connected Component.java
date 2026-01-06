import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Graph {
	
	List<Integer> conn = new ArrayList<>();

	public Graph(List<Integer> conn) {
		this.conn = conn;
	}
	
}

public class Main {
	
	static boolean[] visited;
	static boolean[] finished;
	static boolean[] onStack;
	static List<List<Integer>> SCC;
	static Stack<Integer> stack;
	static Graph[] graph;
	static int[] d;
	static int id = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new Graph[V + 1];
		visited = new boolean[V + 1];
		onStack = new boolean[V + 1];
		finished = new boolean[V + 1];
		stack = new Stack<>();
		d = new int[V + 1];
		SCC = new ArrayList<>();
		
		for (int i = 1; i <= V; i++) {
			graph[i] = new Graph(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].conn.add(b);
		}
		
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) dfs(i);
		}
		
		Collections.sort(SCC, (o1, o2) -> o1.get(0) - o2.get(0));
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(SCC.size()).append("\n");
		for (int i = 0; i < SCC.size(); i++) {
			for (int j : SCC.get(i)) {
				sb.append(j + " ");
			}
			sb.append(-1).append("\n");
		}
		
		
		System.out.println(sb);
	}
	
	static int dfs(int input) {
		
		visited[input] = true;
		d[input] = ++id;
		stack.push(input);
		
		List<Integer> conn = graph[input].conn;
		
		int parent = d[input];
		for (int i : conn) {
			// 방문하지 않은 노드로 가게 되면
			// 해당 노드 의 부모는 노드는 현재노드 이거나 자기가 탐색에서 발견하는 가장 작은 노드이다.
			if (!visited[i]) parent = Math.min(parent, dfs(i));
			else if (!finished[i]) parent = Math.min(parent, d[i]);
		}
		
		if (parent == d[input]) {
			List<Integer> scc = new ArrayList<>();
			while (true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				if (t == input) break;
			}
			Collections.sort(scc);
			SCC.add(scc);
		}
		
		return parent;
		
	}
	
}