import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
        	String city = cities[i].toLowerCase();
        	
        	if (queue.contains(city)) {
        		answer += 1;
        		queue.remove(city);
        		queue.offer(city);
        		
        	} else {
        		answer += 5;
        		queue.offer(city);
        		if (queue.size() > cacheSize) queue.poll();
        	}
        }
        
        return answer;
    }
}