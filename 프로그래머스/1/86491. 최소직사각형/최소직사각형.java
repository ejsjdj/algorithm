class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = Integer.MIN_VALUE;
    	int y = Integer.MIN_VALUE;
    	
        for (int i = 0; i < sizes.length; i++) {
        	x = Math.max(x, Math.max(sizes[i][0], sizes[i][1]));
        	y = Math.max(y, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        
        return x * y;
    }
}