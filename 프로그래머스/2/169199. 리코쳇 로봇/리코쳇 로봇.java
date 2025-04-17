import java.util.PriorityQueue;

class Point implements Comparable<Point>{
	int x;
	int y;
	int step;
	
	public Point(int x, int y, int step) {
		super();
		this.x = x;
		this.y = y;
		this.step = step;
	}
	
	@Override
	public int compareTo(Point o) {
		return this.step - o.step;
	}
}

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int y = 0;
        int x = 0;
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length(); j++) {
        		if (board[i].charAt(j) == 'R') {
        			y = i;
        			x = j;
        		}
        	}
        }
        answer = dijkstra(x, y, board);
        return answer;
    }
    
    int dijkstra(int x, int y, String[] board) {
    	boolean[][] visited = new boolean[board.length][board[0].length()];
    	int[] move = {-1, 0, 1};
    	PriorityQueue<Point> pq = new PriorityQueue<>();
    	pq.add(new Point(x, y, 0));
    	while (!pq.isEmpty()) {
    		Point now = pq.poll();
    		int now_x = now.x;
    		int now_y = now.y;
    		int now_step = now.step;
    		// 오른쪽으로 이동
    		for (int i = 0; i < board[0].length(); i++) {
    			if (now_x + i + 1 == board[0].length() || board[now_y].charAt(now_x + i + 1) == 'D') {
    				if (board[now_y].charAt(now_x + i) == 'G') return now_step + 1;
    				if(!visited[now_y][now_x + i]) {
    					visited[now_y][now_x + i] = true;
    					pq.add(new Point(now_x + i, now_y, now_step + 1));
    				}
    				break;
    			}
    		}
    		
    		// 위쪽으로 이동
    		for (int i = 0; i < board.length; i++) {
    			if (now_y - i - 1 == -1 || board[now_y - i - 1].charAt(now_x) == 'D') {
    				if (board[now_y-i].charAt(now_x) == 'G') return now_step + 1;
    				if (!visited[now_y - i][now_x]) {
    					visited[now_y - i][now_x] = true;
    					pq.add(new Point(now_x, now_y - i, now_step + 1));
    				}
    				break;
    			}
    		}
    		
    		// 왼쪽으로 이동
    		for (int i = 0; i < board[0].length(); i++) {
    			if (now_x - i - 1 == -1 || board[now_y].charAt(now_x - i - 1) == 'D') {
    				if (board[now_y].charAt(now_x - i) == 'G') return now_step + 1;
    				if(!visited[now_y][now_x - i]) {
    					visited[now_y][now_x - i] = true;
    					pq.add(new Point(now_x - i, now_y, now_step + 1));
    				}
    				break;
    			}
    		}
    		
    		// 아래쪽으로 이동
    		for (int i = 0; i < board.length; i++) {
    			if (now_y + i + 1== board.length || board[now_y + i + 1].charAt(now_x) == 'D') {
    				if (board[now_y + i].charAt(now_x) == 'G') return now_step + 1;
    				if (!visited[now_y + i][now_x]) {
    					visited[now_y + i][now_x] = true;
    					pq.add(new Point(now_x, now_y + i, now_step + 1));
    				}
    				break;
    			}
    		}
    	}
    	
    	return -1;
    }
}