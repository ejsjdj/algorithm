class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        
        String value = board[h][w];
        for (int i = 0; i < x.length; i++) {
        	int now_x = h + x[i];
        	int now_y = w + y[i];
        	if (0 <= now_x && now_x < board.length && 0 <= now_y && now_y < board[0].length ) {
        		if (value.equals(board[now_x][now_y])) answer++;
        	}
        }
        return answer;
    }
}