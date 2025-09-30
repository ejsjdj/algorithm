class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] arr = new int[board.length+1][board[0].length + 1];
        
        for (int i = 0; i < skill.length; i++) {
            
            int type = skill[i][0];
            
            int row1 = skill[i][1];
            int col1 = skill[i][2];
            
            int row2 = skill[i][3];
            int col2 = skill[i][4];
            
            int effect = skill[i][5];
            
            if (type == 1) { // 공격
                arr[row1][col1] -= effect;
                arr[row2 + 1][col1] += effect;
                arr[row1][col2 + 1] += effect;
                arr[row2+1][col2+1] -= effect;
            } 
            else if (type == 2) { // 회복
                arr[row1][col1] += effect;
                arr[row2 + 1][col1] -= effect;
                arr[row1][col2 + 1] -= effect;
                arr[row2+1][col2+1] += effect;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] += arr[i][j-1];
            }
        }
        
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 1; j < arr.length; j++) {
                arr[j][i] += arr[j - 1][i];
            }
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                board[i][j] += arr[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}