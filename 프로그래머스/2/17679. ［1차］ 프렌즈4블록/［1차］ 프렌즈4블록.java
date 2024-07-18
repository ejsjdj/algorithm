class Solution {
	
	boolean[][] bb;
	char[][] display;
	boolean flag=true;;
	int answer = 0;
	
    public int solution(int m, int n, String[] board) {
        display = new char[m][n];
        bb = new boolean[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		display[i][j] = board[i].charAt(j);
        	}
        }
        
        while (flag) {
        	flag = false;
	        for (int i = 0; i < m - 1; i++) {
	        	for (int j = 0; j < n - 1; j++) {
	        		BFS(i, j);
	        	}
	        }
	        check();
	        drop();
	        bb = new boolean[m][n];
        }
        return answer;
    }
    
    void BFS(int x, int y) {
    	char c = display[x][y];
    	if (c != 'x' && c == display[x][y+1] && c == display[x+1][y] && c == display[x+1][y+1]) {
    		bb[x][y] = true;
    		bb[x+1][y] = true;
    		bb[x][y+1] = true;
    		bb[x+1][y+1] = true;
    	}
    }
    void check() {
    	for (int i = 0; i < display.length; i++) {
    		for (int j = 0; j < display[i].length; j++) {
    			if (bb[i][j]) {
    				display[i][j] = 'x';
    				flag = true;
    				answer++;
    			}
    		}
    	}
    }
    void drop() {
    	for (int i = display.length-1; i >= 0; i--) {
    		for (int j = 0; j < display[i].length; j++) {
    			if (display[i][j] == 'x') {
    				for (int k = i-1; k >= 0; k--) {
    					if (display[k][j] != 'x') {
    						display[i][j] = display[k][j];
    						display[k][j] = 'x';
    						break;
    					}
    				}
    			}
    		}
    	}
    }
}