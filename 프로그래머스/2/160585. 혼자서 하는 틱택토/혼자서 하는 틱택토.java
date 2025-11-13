class Solution {
    public int solution(String[] board) {
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int win1 = 0;
        int win2 = 0;
        
        for (int i = 0; i < 3; i++) {
        	if (board[i].charAt(0) != '.' && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
        		if (board[i].charAt(0) == 'O') win1 += 1;
        		else if (board[i].charAt(0) == 'X') win2 += 1;
        	}
        	if (board[0].charAt(i) != '.' && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
        		if (board[0].charAt(i) == 'O') win1 += 1;
        		else if (board[0].charAt(i) == 'X') win2 += 1;
        	}
        }
        
        if (board[1].charAt(1) != '.' && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
    		if (board[1].charAt(1) == 'O') win1 += 1;
    		else if (board[1].charAt(1) == 'X') win2 += 1;
        }
        
        if (board[1].charAt(1) != '.' && board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2)) {
    		if (board[1].charAt(1) == 'O') win1 += 1;
    		else if (board[1].charAt(1) == 'X') win2 += 1;
        }
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length(); j++) {
        		
        		if (board[i].charAt(j) == 'O') {
        			cnt1++;
        		}
        		else if (board[i].charAt(j) == 'X') {
        			cnt2++;
        		}
        	
        	}
        }
        
        if (win1 != 0 && win2 != 0) return 0;
        if (win1 > 2) return 0;
        if (win2 > 2) return 0;
        if (cnt1 < cnt2) return 0;
        if (win1 > 0 && cnt1 <= cnt2) return 0;
        if (win2 > 0 && cnt1 != cnt2) return 0;
        if (cnt1 > cnt2 + 1) return 0;
        
        return 1;
    }
}