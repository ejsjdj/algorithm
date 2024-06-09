import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int right = score.length-1;
        int left = right - m+1;
        
        while (left >= 0) {
        	answer += score[left] * m;
        	right -= m;
        	left -= m;
        }
        
        
        return answer;
    }
}