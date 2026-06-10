class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double[] ave = new double[score.length];
        
        for (int i = 0; i < ave.length; i++) {
        	ave[i] = ((double)score[i][0] + score[i][1]) / 2;
        }
        
        for (int i = 0; i < ave.length; i++) {
        	int cnt = 1;
        	for (int j = 0; j < ave.length; j++) {
        		if (ave[i] < ave[j]) cnt += 1;
        	}
        	answer[i] = cnt;
        }
        
        return answer;
    }
}