class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
    	
    	int numer = numer1 * denom2 + numer2 * denom1;		// 24
    	int denom = denom1 * denom2;						// 36
    	for (int i = 2; i <=  Math.min(denom,numer); i++) {	// 12,18 6, 9 2 3
    		if (numer % i == 0 && denom % i == 0) {
    			numer /= i;
    			denom /= i;
    			i = 1;
    		}
    	}
    	
    	
        int[] answer = {numer, denom};
        System.out.printf("%d/%d",answer[0], answer[1]);
        return answer;
    }
}