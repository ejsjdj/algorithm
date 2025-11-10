class Solution {
	
	int[] arr;
	int n;
	
    public int solution(int n) {
        int answer = 0;
        
        this.arr = new int[n];
        this.n = n;
        
        for (int i = 0; i < n; i++) {
        	arr[0] = i;
        	answer += nQueen(1);
        }
        
        return answer;
    }
    
    boolean isPromising(int col, int row) {
    	for (int i = 0; i < col; i++) {
    		if (row == arr[i]) return false;
    		if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
    	}
    	return true;
    }
    
    int nQueen(int col) {
    	if (col == n) return 1;

    	int result = 0;
    	
    	for (int i = 0; i < n; i++) {
    		arr[col] = i;
    		if (isPromising(col, i)) {
    			result += nQueen(col + 1);
    		}
    	}
    	
    	return result;
    }
}