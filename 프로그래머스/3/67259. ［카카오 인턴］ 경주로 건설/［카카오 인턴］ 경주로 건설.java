import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

	int row;
	int col;
	int direction;
	int cost;

	public Node(int row, int col, int direction, int cost) {
		this.row = row;
		this.col = col;
		this.direction = direction;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

class Solution {
	public int solution(int[][] board) {
		
		int answer = 0;
		
    		int[][][] costBoard = new int[board.length][board[0].length][4];
    		
        for (int i = 0; i < board.length; i++) {
        		for (int j = 0; j < board[i].length; j++) {
        			Arrays.fill(costBoard[i][j], Integer.MAX_VALUE / 2);
        		}
        }
        
        costBoard[0][0][0] = 0;
        costBoard[0][0][1] = 0;
        costBoard[0][0][2] = 0;
        costBoard[0][0][3] = 0;
        
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int rowLength = board.length;
        int colLength = board[0].length;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 직선의 100원
        // 코너는 500원
        pq.add(new Node(0, 0, 1, 0));
        pq.add(new Node(0, 0, 3, 0));
        
        while (!pq.isEmpty()) {
	        	Node now = pq.poll();
	        	
	        	int row = now.row;
	        	int col = now.col;
	        	int direction = now.direction;
	        	int cost = now.cost;
	        	
//	        	if (row == rowLength - 1 && col == colLength - 1) break;
	        	
	        	for (int i = 0; i < 4; i++) {
	        		int m_row = row + move[i][0];
	        		int m_col = col + move[i][1];

	        		int m_cost = 0;
	        		if (i == direction) m_cost = cost + 100;
	        		else if (i != direction) m_cost = cost + 600;
	        		
	        		if (0 <= m_row && m_row < rowLength && 0 <= m_col && m_col < colLength && costBoard[m_row][m_col][i] > m_cost && board[m_row][m_col] != 1) {
	        			costBoard[m_row][m_col][i] = m_cost;
	        			pq.add(new Node(m_row, m_col, i, m_cost));
	        		}
	        	}
        }
        
//        for (int i = 0; i < board.length; i++) {
//        		for (int j = 0; j < board[i].length; j++) {
//        			System.out.print(costBoard[i][j] + " ");
//        		}
//        		System.out.println();
//        }

        answer = Math.min(costBoard[board.length - 1][board[0].length - 1][0], Math.min(costBoard[board.length - 1][board[0].length - 1][1], Math.min(costBoard[board.length - 1][board[0].length - 1][2], costBoard[board.length - 1][board[0].length - 1][3])));
        return answer;
    }
}