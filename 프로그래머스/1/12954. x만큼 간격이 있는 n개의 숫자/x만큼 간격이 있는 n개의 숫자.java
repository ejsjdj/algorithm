class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int i = 0;
        while (i < n) {
        	answer[i] = (long)x + (long)x * i;
        	i++;
        }
        
        return answer;
    }
}