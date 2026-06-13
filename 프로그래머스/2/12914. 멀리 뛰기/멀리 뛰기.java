
class Solution {
    public long solution(int n) {
        int left = 1;
        int right = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
        	tmp = right;
        	right = (left + right) % 1234567;
        	left = tmp;
        }
        return n == 1 ? left : right;
    }
} 
