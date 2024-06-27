import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
        	pq.add(Long.valueOf(scoville[i]));
        }
        int cnt = 0;
        while (pq.peek() < K && pq.size() >= 2) {
        	Long a = pq.poll();
        	Long b = pq.poll();
        	pq.add(a + b * 2);
        	cnt++;
        }
        if (pq.size() < 2 && pq.peek() < K) return -1;
        return cnt;
    }
}