import java.util.LinkedList;
import java.util.Queue;

class Solution {
	boolean[][] visited;
	int[][] A;
	int[] xp = {-1, 0, 0, 1};
	int[] yp = {0, 1, -1, 0};
    public int solution(int[][] maps) {
        int answer = -1;
        
        int N = maps.length;
        int M = maps[0].length;
        
        visited = new boolean[N][M];
        A = new int[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        A[0][0] = 1;
        while (!queue.isEmpty()) {
        	int[] location = queue.poll();
        	int x = location[0];
        	int y = location[1];
        	for (int i = 0; i < 4; i++) {
        		int new_x = x + xp[i];
        		int new_y = y + yp[i];
        		if (0 <= new_x && new_x < N && 0 <= new_y && new_y < M && visited[new_x][new_y] != true && maps[new_x][new_y] == 1) {
        			visited[new_x][new_y] = true;
        			A[new_x][new_y] = A[x][y] + 1;
        			queue.add(new int[] {new_x, new_y});
        			if (new_x == N-1 && new_y == M-1) return A[new_x][new_y];
        		}
        	}
        }
        
        return answer;
    }
}