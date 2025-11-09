class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        
        double limit = (double) d/k;
        double T = (double) d / k;
        T = T * T;
        
        for (int i = 0; i <= limit; i++) {
            double remainder = T - (double) i * i;
            answer += (int) Math.sqrt(remainder) + 1;
        }
        return answer;
    }
}