import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long s1 = 0;
        long s2 = 0;
        long sum = 0;
        
        for (int i = 0; i < queue1.length; i++) {
        	
        	int n1 = queue1[i];
        	int n2 = queue2[i];
        	
        	q1.add(n1);
        	q2.add(n2);
        	
        	s1 += n1;
        	s2 += n2;
        	
        }
        
        sum = (s1 + s2)/2;
        
        if (s1 > sum) {
        	while (s1 != sum) {
        		if (s1 > sum) {
        			if (q1.isEmpty()) return -1;
	        		int now = q1.poll();
	        		s1 -= now;
	        		q2.add(now);
	        		answer++;
        		} else if (s1 < sum) {
        			if (q2.isEmpty()) return -1;
        			int now = q2.poll();
        			s1 += now;
        			q1.add(now);
        			answer++;
        		}
        		if (answer > queue1.length * 2) return -1;
        	}
        } else if (s2 > sum) {
        	while (s2 != sum) {
        		if (s2 > sum) {
        			if (q2.isEmpty()) return -1;
	        		int now = q2.poll();
	        		s2 -= now;
	        		q1.add(now);
	        		answer++;
        		} else if (s2 < sum){
        			if (q1.isEmpty()) return -1;
        			int now = q1.poll();
        			s2 += now;
        			q2.add(now);
        			answer++;
        		}
        		if (answer > queue1.length * 2) return -1;
        	}
        }
        
        return answer;
    }
}