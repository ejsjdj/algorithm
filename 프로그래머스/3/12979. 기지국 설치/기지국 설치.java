class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[] len = new int[stations.length+1];
        
        len[0] = stations[0]-w-1;
        len[len.length-1] = n-(stations[stations.length-1]+w);
        
        
        for (int i = 1; i < len.length - 1; i++) {
        	len[i] = stations[i] - stations[i-1] - 2 * w - 1;
        }
        
        for (int i = 0; i < len.length; i++) {
        	if (len[i] > 0) {
        		answer += len[i] / (w * 2 + 1);
        		if (len[i] % (w * 2 + 1) > 0) answer += 1;
        	}
        }
        
        
        
        return answer;
    }
}