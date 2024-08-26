class Solution {
    public int solution(int n) {
        
        int left = 0;
        int right = 1;
        int mid = 0;
        
        for (int i = 0; i < n; i++) {
        	mid = (right + left) % 1000000007;
        	left = right;
        	right = mid ;
        }
        
        return mid;
    }
}