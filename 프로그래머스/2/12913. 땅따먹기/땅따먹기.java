class Solution {	
    int solution(int[][] land) {
    	int result = 0;
    	
    	for (int i = 1; i < land.length; i++) {
    		for (int j = 0; j < 4; j++) {
    			
    			int max = 0;
    			
    			for (int k = 0; k < 4; k++) {
    				if ((j != k) && (land[i-1][k] > max)) {
    					max = land[i-1][k];
    				}
    			}
    			land[i][j] += max;
    		}
    	}
    	for (int i = 0; i < 4; i++) {
    		if (result < land[land.length - 1][i]) result = land[land.length - 1][i];
    	}
    	return result;
    }
}