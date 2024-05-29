import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();  
        
        for (int i = 0; i < moves.length; i++) {
        	int krain = moves[i];
        	for (int j = 0; j < board.length; j++) {
        		if (board[j][krain-1] != 0) {
        			list.add(board[j][krain-1]);
        			board[j][krain-1] = 0;
        			break;
        		}
        	}
        }
        
        while (true) {
            boolean flag = true;
        	for (int i = 0; i < list.size() - 1; i++) {
        		if (list.get(i) == list.get(i + 1)) {

        			answer += 2;
        			list.remove(i+1);
        			list.remove(i);
        			flag = false;
        		}
        	}
        	if (flag) break;
        }
        return answer;
    }
}