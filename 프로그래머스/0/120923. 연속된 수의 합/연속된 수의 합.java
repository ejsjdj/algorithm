import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < num; i++) {
        	deque.addLast(i);
        	sum += i;
        }
        while (sum != total) {
        	if (sum > total) {
        		int N = deque.peekFirst() - 1;
        		sum -= deque.pollLast();
        		sum += N;
        		deque.addFirst(N);
        	}
        	else if (sum < total) {
        		int N = deque.peekLast() + 1;
        		sum -= deque.pollFirst();
        		sum += N;
        		deque.addLast(N);
        	}
        }
        for (int i = 0; i < num; i++) {
        	answer[i] = deque.pollFirst();
        }
        return answer;
    }
}