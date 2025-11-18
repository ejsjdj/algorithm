class Solution {
    public int solution(int n) {
        
        return catalan(n);
    }
    
    int catalan(int n) {
    		double result = 1;
    		
    		for (int i = 0; i < n; i++) {
    			result = result * (2 * n - i) / (i + 1);
    		}
    		
    		return (int) result / (n + 1);
    		
    }
}