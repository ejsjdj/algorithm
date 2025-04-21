import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int currentSum = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            currentSum += enemy[i];
            
            // 현재 합이 n을 초과하면 k를 사용하여 최대값 제거
            while (currentSum > n && k > 0) {
                int removed = pq.poll();
                currentSum -= removed;
                k--;
            }
            
            // k를 모두 사용했는데도 합이 초과되면 종료
            if (currentSum > n) {
                return i;
            }
        }
        return enemy.length;
    }
}