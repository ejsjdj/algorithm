import java.util.PriorityQueue;

class Solution {
	
	int[] parents;
	PriorityQueue<Edge> pq;
	
    public int solution(int n, int[][] costs) {
        
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        
        pq = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
        	int a = costs[i][0];
        	int b = costs[i][1];
        	int weight = costs[i][2];
        	pq.add(new Edge(a, b, weight));
        }
        
        int useEdge = 0;
        int answer = 0;
        
        while (useEdge < n - 1) {
        	Edge now = pq.poll();
        	if (find(now.a) != find(now.b)) {
        		union(now.a, now.b);
        		answer += now.weight;
        		useEdge++;
        	}
        }
        
        return answer;
    }
    
    void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if (a != b) parents[b] = a;
    }
    
    int find(int a) {
    	if (parents[a] == a) return a;
    	return parents[a] = find(parents[a]);
    }
}

class Edge implements Comparable<Edge> {
	int a;
	int b;
	int weight;
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

	public Edge(int a, int b, int weight) {
		super();
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
}