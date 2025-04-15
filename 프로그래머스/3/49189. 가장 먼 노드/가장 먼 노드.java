import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Graph implements Comparable<Graph>{
	int num;
	int dist = Integer.MAX_VALUE;
	List<Integer> conn;
	
	public Graph(int num) {
		this.num = num;
		this.conn = new ArrayList<>();
	}
	
	@Override
	public int compareTo(Graph o) {
		return this.dist - o.dist;
	}
}

class Solution {
    public int solution(int n, int[][] edge) {

        Graph[] graph = new Graph[n + 1];
        for (int i = 1; i < graph.length; i++) graph[i] = new Graph(i);
        
        for (int i = 0; i < edge.length; i++) {
        	int left = edge[i][0];
        	int right = edge[i][1];
        	graph[left].conn.add(right);
        	graph[right].conn.add(left);
        }
        
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        graph[1].dist = 0;
        pq.add(graph[1]);
        
        while(!pq.isEmpty()) {
        	Graph now = pq.poll();
        	for (int next : now.conn) {
        		if (graph[next].dist > now.dist + 1) {
        			graph[next].dist = now.dist + 1;
        			pq.add(graph[next]);
        		}
        	}
        }
        
        int max = 0;
        int maxCnt = 0;
        for (int i = 1; i < graph.length; i++) {
        	if (graph[i].dist > max) {
        		max = graph[i].dist;
        		maxCnt = 1;
        	} else if (graph[i].dist == max) {
        		maxCnt += 1;
        	}
        }
        
        return maxCnt;
    }
}