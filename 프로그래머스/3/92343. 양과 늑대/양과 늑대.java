import java.util.ArrayList;
import java.util.List;

class Node {
	int type;
	List<Integer> children;
	public Node(int type) {
		this.type = type;
		this.children = new ArrayList<>();
	}
}

class Solution {
	
	Node[] tree;
	int answer = 0;
	boolean[] visited;
	
	public int solution(int[] info, int[][] edges) {
		
		tree = new Node[info.length];
		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new Node(info[i]);
		}
		
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			tree[parent].children.add(child);
		}
		
		visited = new boolean[info.length];
		
		DFS(0, 0, 0);
		
		return answer;
	}

	public void DFS(int index, int sheep, int wolf) {
		visited[index] = true;
		
		if (tree[index].type == 0) sheep += 1;
		else wolf += 1;
		
		if (wolf >= sheep) {
			visited[index] = false;
			answer = Math.max(answer, sheep);
			return;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				for (int j : tree[i].children) {
					if (!visited[j]) {
						DFS(j, sheep, wolf);	
					}
				}
			}
		}
		visited[index] = false;
		answer = Math.max(answer, sheep);
		return;
	}
}