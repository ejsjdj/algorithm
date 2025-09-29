import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    
}
class Chair {
    int row;
    int col;
    int step;
    Chair(int row, int col, int step) {
        this.step = step;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        int[][][] arr = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    char c = places[i][row].charAt(col);
                    if (c == 'P') arr[i][row][col] = 1;	// 사람일 경우
                    else if (c == 'O') arr[i][row][col] = 0;	// 빈칸일 경우
                    else arr[i][row][col] = -1;			// 벽일 경우
                }
            }
        }
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < 5; i++) {
        	boolean flag = false;
            for (int row = 0; row < 5; row++) {
            	if (flag) break;
            	boolean[][] visited = new boolean[5][5];
                for (int col = 0; col < 5; col++) {
                	if (flag) break;
                	Queue<Chair> queue = new LinkedList<>();
                    if (arr[i][row][col] == 1) {
                    	queue.add(new Chair(row, col, 0));
                    	visited[row][col] = true;
                        while (!queue.isEmpty()) {
                            Chair now = queue.poll();
                            int now_row = now.row;
                            int now_col = now.col;
                            int now_step = now.step;
                            
                            if (arr[i][now_row][now_col] == 1 && !visited[now_row][now_col]) {
                            	answer[i] = 0;
                            	flag = true;
                            	break;
                            } else if (arr[i][now_row][now_col] == -1 || now_step == 2) {
                            	continue;
                            }
                            
                            for (int l = 0; l < 4; l++) {
                                int move_row = now_row + move[l][0];
                                int move_col = now_col + move[l][1];
                                
                                if (0 <= move_row && move_row < 5 && 0 <= move_col && move_col < 5) {
                                	queue.add(new Chair(move_row, move_col, now_step + 1));
                                }
                            }
                        }
                    }
                    
                }
            }
        }
        
        return answer;
    }
}