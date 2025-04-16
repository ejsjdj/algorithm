class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        
        long[][] sum = new long[sequence.length][2];

        sum[0][0] = sequence[0];
        sum[0][1] = -sequence[0];
        
        int bi = -1;
        for (int i = 1; i < sequence.length; i++) {
        	sum[i][0] = Math.max(sum[i-1][0], 0) + sequence[i] * bi;
        	bi = -bi;
        	sum[i][1] = Math.max(sum[i-1][1], 0) + sequence[i] * bi;
        }
        
        for (int i = 0; i < sequence.length; i++) {
        	answer = Math.max(Math.max(sum[i][0],  sum[i][1]), answer);
        }

        return answer;
    }
}