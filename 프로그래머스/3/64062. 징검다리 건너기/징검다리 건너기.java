import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            // 인덱스 차이로 고려할 필요가 없어진 인덱스는 데크에서 뺌
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 현재 값보다 작은 값을 덱에서 제거
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            // 현재 인덱스를 덱에 추가
            deque.offerLast(i);

            // 첫 번째 슬라이딩 윈도우가 완성된 후부터 최소값 갱신
            if (i >= k - 1) {
                min = Math.min(min, stones[deque.peekFirst()]);
            }
        }

        return min;
    }
}