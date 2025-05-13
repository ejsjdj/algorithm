class Solution {
    public int solution(int[] num_list) {
        
    	int n  = 0;
    	
    	for (int i = 0; i < num_list.length; i++) {
    		while (num_list[i] != 1) {
    			if (num_list[i] % 2 == 0) {
    				num_list[i] = num_list[i] / 2;
    				n += 1;
    			} else {
    				num_list[i] -= 1;
    				num_list[i] /= 2;
    				n += 1;
    			}
    		}
    	}
    	
        return n;
    }
}