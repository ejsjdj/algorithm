class Solution {
    public int[] solution(int n, long left, long right) {

        
        
        int[] arr1 = new int[(int)(right - left + 1)];
        
        int x = (int)(left/n);
        int y = (int)(left%n);
        for (int i = 0; i < (int)(right-left + 1); i++) {
        	arr1[i] = x > y ? x + 1 : y + 1;
        	y++;
        	if (y == n) {
        		y = 0;
        		x += 1;
        	}
        }
        
        return arr1;
    }
}