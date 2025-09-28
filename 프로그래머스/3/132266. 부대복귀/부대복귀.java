import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int value;
	List<Integer> list;
	
	public Node() {
		value = -1;
		list = new ArrayList<>();
	}
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        Node[] node = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
        	node[i] = new Node();
        }
        
        for (int i = 0; i < roads.length; i++) {
        	int a = roads[i][0];
        	int b = roads[i][1];
        	node[a].list.add(b);
        	node[b].list.add(a);
        }
        
        BFS(destination, node);
        
        
        for (int i = 0; i < sources.length; i++) {
        	int army = sources[i];
        	answer[i] = node[army].value;
        }
        
        return answer;
    }
    
    void BFS(int start, Node[] node) {
    	
    	node[start].value = 0;
    	
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(node[start]);
    	
    	while (!queue.isEmpty()) {
    		Node now = queue.poll();
    		for (int i : now.list) {
    			if (node[i].value == -1) {
    				node[i].value = now.value + 1;
    				queue.add(node[i]);
    			}
    		}
    	}
    	
    }
}