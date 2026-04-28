import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int row;
	int col;
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Solution {
	
	char[][] map;
	int[][] check;
	
    public int solution(String[] storage, String[] requests) {
    	
        int answer = storage.length * storage[0].length();
        check = new int[storage.length][storage[0].length()];
        
        makeMap(storage);
        
        for (int i = 0; i < requests.length; i++) {
        	String request = requests[i];
        	if (request.length() == 2) answer -= crain(request.charAt(0));
        	else answer -= forkLift(request.charAt(0));
        }
        
//        for (int i = 0; i < map.length; i++) {
//        	for (int j = 0; j < map[i].length; j++) {
//        		System.out.print(map[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        return answer;
    }
    
    int forkLift(char request) {
    	
    	int cnt = 0;
    	
    	List<Node> list = new ArrayList<>();
    	
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[0].length; j++) {
    			if (map[i][j] == request) list.add(new Node(i, j));
    		}
    	}
    	
    	boolean[] possible = new boolean[list.size()];
    	for (int i = 0; i < list.size(); i++) {
    		if (isPossible(list.get(i))) {
    			possible[i] = true;
    		}
    	}
    	
    	for (int i = 0; i < list.size(); i++) {
    		if (possible[i]) {
    			Node node = list.get(i);
    			int row = node.row;
    			int col = node.col;
    			map[row][col] = '0';
    			check[row][col] = 1;
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
    
    boolean isPossible(Node node) {
    	int[] dr = {-1, 0, 1, 0};
    	int[] dc = {0, -1, 0, 1};
    	
    	Queue<Node> queue = new LinkedList<>();
    	boolean[][] visited = new boolean[map.length][map[0].length];
    	queue.add(node);
    	
    	while (!queue.isEmpty()) {
    		Node cur = queue.poll();
    		int row = cur.row;
    		int col = cur.col;
    		if (row == 0 || col == 0 || row == map.length - 1 || col == map[0].length - 1 || check[row][col] == 1) {
    			check[node.row][node.col] = 1;
    			return true;
    		}
    		visited[row][col] = true;
    		
    		for (int i = 0; i < 4; i++) {
    			int m_row = row + dr[i];
    			int m_col = col + dc[i];
    			
    			if (0 <= m_row && m_row < map.length && 0 <= m_col && m_col < map[0].length 
    					&& map[m_row][m_col] == '0' && !visited[m_row][m_col]) {
    				queue.add(new Node(m_row, m_col));
    			}
    			
    		}
    		
    	}
    	
    	return false;
    }
    
    void makeMap(String[] storage) {
    	map = new char[storage.length][storage[0].length()];
    	for (int i = 0; i < storage.length; i++) {
    		for (int j = 0; j < storage[i].length(); j++) {
    			map[i][j] = storage[i].charAt(j);
    			
    		}
    	}
    }
    
    int crain(char request) {
    	
    	int cnt = 0;
    	
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[i].length; j++) {
    			if (map[i][j] == request) {
    				isPossible(new Node(i,j));
    				cnt++;
    				map[i][j] = '0';
    			}
    		}
    	}
    	
    	return cnt;
    }
    
}