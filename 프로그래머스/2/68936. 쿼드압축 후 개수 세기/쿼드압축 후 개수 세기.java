class Solution {
	
	int[] cnt = {0, 0};
	
	void check(int[][] arr, int x, int y, int end_x, int end_y) {
		
		int now = arr[x][y];
		
		int mid_x = (x + end_x) / 2;
		int mid_y = (y + end_y) / 2;
		
		for (int i = x; i < end_x; i++) {
			
			for (int j = y; j < end_y; j++) {
				
				if (arr[i][j] != now) {
					
					check(arr, x, y, mid_x, mid_y);
					check(arr, mid_x, y, end_x, mid_y);
					check(arr, x, mid_y, mid_x, end_y);
					check(arr, mid_x, mid_y, end_x, end_y);
					return ;
				}
			}
		}
		
		cnt[now]++;
		
	}
	
	public int[] solution(int[][] arr) {
        
		int len = arr.length;
		check(arr, 0, 0, len, len);
        
        return cnt;
    }
}