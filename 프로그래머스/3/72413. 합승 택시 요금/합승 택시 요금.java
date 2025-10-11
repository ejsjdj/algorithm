import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int target;
	int weight;
	
	public Node(int target, int value) {
		super();
		this.target = target;
		this.weight = value;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

class Solution {
	
	List<List<Node>> graph = new ArrayList<>();
	
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n + 1; i++) {
        		graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
        		int first = fares[i][0];
        		int second = fares[i][1];
        		int weight = fares[i][2];
        		graph.get(first).add(new Node(second, weight));
        		graph.get(second).add(new Node(first, weight));
        }
        
        int[][] results = new int[3][n + 1];
        
        results[0] = dijkstra(a);
        	results[1] = dijkstra(b);
        	results[2] = dijkstra(s);
        
        	for (int i = 1; i < n + 1; i++) {
        		answer = Math.min(answer, results[0][i] + results[1][i] + results[2][i]);
        	}
        	
        return answer;
    }
    
    public int[] dijkstra(int start) {
    		PriorityQueue<Node> pq = new PriorityQueue<>();
    		
    		int[] distance = new int[graph.size()];
    		Arrays.fill(distance, Integer.MAX_VALUE);
    		distance[start] = 0;
    		
    		pq.add(new Node(start, 0));
    		
    		while (!pq.isEmpty()) {
    			Node now = pq.poll();
    			int index = now.target;
    			
    			for (Node neighbor : graph.get(index)) {
    				int target = neighbor.target;
    				int weight = neighbor.weight;
    				if (distance[target] > distance[index] + weight) {
    					distance[target] = distance[index] + weight;
    					pq.add(new Node(target, distance[target]));
    				}
    			}
    		}
    		
    		return distance;
    }
}