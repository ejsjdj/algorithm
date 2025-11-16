class Solution {
	
	long[] arr;

	public int solution(int n) {
        
        arr = new long[n + 4];
        
        arr[2] = 3;
        arr[4] = 11;
        arr[6] = 41;
        
        for (int i = 6; i <= n; i = i + 2) {
        	arr[i] = calc(i);
        }
        
        return (int) arr[n];
    }
	
	long calc(int n) {
		if (arr[n] != 0) return arr[n];
		
		else {
			return (4 * calc(n - 2) - calc(n - 4) + 1000000007) % 1000000007 ;
		}
		
	}
}