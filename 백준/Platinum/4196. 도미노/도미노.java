import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Graph {
	List<Integer> connection;	
	public Graph() {
		this.connection = new ArrayList<>();
	}
}

public class Main {
	
	static Graph[] graph;
	static int idx = 0;
	static Stack<Integer> stack;
	static List<List<Integer>> SCC;
	static boolean[] visited;
	static boolean[] finished;
	static int[] d;
	static int V;
	static int[] sccId;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {			
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			sccId = new int[V + 1];
			graph = new Graph[V + 1];
			visited = new boolean[V + 1];
			finished = new boolean[V + 1];
			stack = new Stack<>();
			d = new int[V + 1];
			SCC = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph[i] = new Graph();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph[A].connection.add(B);
			}
			
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}
			
			int result = tological();
			System.out.println(result);
		}
		
	}
	
	static int dfs(int input) {
		
		visited[input] = true;
		d[input] = ++idx;
		stack.push(input);
		int parent = d[input];
		
		for (int i : graph[input].connection) {
			
			if (!visited[i]) parent = Math.min(parent, dfs(i));
			else if (!finished[i]) parent = Math.min(parent, d[i]);
			
		}
		
		if (parent == d[input]) {
			List<Integer> scc = new ArrayList<>();
			while (true) {
				int top = stack.pop();
				d[top] = parent;
				sccId[top] = SCC.size();
				scc.add(top);
				finished[top] = true;
				d[input] = parent;
				if (top == input) break;
			}
			SCC.add(scc);
		}
		
		return parent;
	}
	
	static int tological() {
		int[] inDegree = new int[SCC.size()];
		
		for (int i = 1; i <= V; i++) {
			for (int j : graph[i].connection) {
				
				// 노드와 연결된 지점의 SCC가 지금 SCC 와 다르면 연결된 지점의 SCC 에 진입차수 추가
				if (d[j] != d[i]) {
					inDegree[sccId[j]]++;
				}
				
			}
		}
		int answer = 0;
		for (int i = 0; i < SCC.size(); i++) {
			if (inDegree[i] == 0) answer++;
		}
		
		return answer;
	}
}