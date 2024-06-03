class Solution {
    public int[][] solution(int n) {
        int length = n;
		int[][] arr = new int[length][length];
		int num = 1;
		int x = 0;
		int y = -1;
		int sign = 1;
		
		while (true) {
			for (int i = 0; i < length; i++) {
				y += sign;
				arr[x][y] = num++;
			}
			length--;
			if(length == 0) {
				break;
			}
			for (int i = 0; i < length; i++) {
				x += sign;
				arr[x][y] = num++;
			}
			sign = -sign;
		}
		return arr;
    }
}