import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
    	
    	int sum = 0;
    	
    	Queue<Integer> queue = new LinkedList<>();
    	
    	
    	for (int i = 0; i < players.length; i++) {
    		
    		while (!queue.isEmpty() && queue.peek() + k == i) {
        		queue.poll();
        	}
    		
    		int num = players[i];
			int n = num / m;
			while (queue.size() < n) {
				queue.add(i);
				sum++;
			}
			
    	}
    	
        return sum;
    }
}