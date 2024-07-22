import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int start = s / n;
        int mod = s % n;
        if (n > s) return new int[]{ -1 };
        for (int i = 0; i < answer.length - mod; i++) {
        	answer[i] = start;
        }
        for (int i = answer.length - mod; i < answer.length; i++) {
        	answer[i] = start+1;
        }
        
        return answer;
    }
}