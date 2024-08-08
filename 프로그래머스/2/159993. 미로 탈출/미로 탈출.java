import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	boolean[][] visited;
	int[] X = {-1, 0, 0, 1};
	int[] Y = {0, 1, -1, 0};
	
	
    public int solution(String[] maps) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        visited = new boolean[maps[0].length()][maps.length];
        
        for (int i = 0; i < maps.length; i++) {		// 시작점을 구하는 반복문
        	boolean flag = false;
        	for (int j = 0; j < maps[i].length(); j++) {
        		if (maps[i].charAt(j) == 'S') {
        			x = j;
        			y = i;
        			flag = true;
        			break;
        		}
        	}
        	if (flag) break;
        }
        Queue<int[]> queue = new LinkedList<>();
        
        int lx = 0;
        int ly = 0;
        int lcnt = 0;
        queue.add(new int[] {x, y, 0});
        
        while (!queue.isEmpty()) {
        	int[] now = queue.poll();
        	int now_x = now[0];
        	int now_y = now[1];
        	int cnt = now[2];
        	if (maps[now_y].charAt(now_x) == 'L') {
        		lx = now_x;
        		ly = now_y;
        		lcnt = cnt;
        		break;
        	}
        	for (int i = 0; i < 4; i++) {
        		int new_x = now_x + X[i];
        		int new_y = now_y + Y[i];
        		if (0 <= new_x && new_x < maps[0].length() && 0 <= new_y && new_y < maps.length && !visited[new_x][new_y] && maps[new_y].charAt(new_x) != 'X') {
        			visited[new_x][new_y] = true;
        			queue.add(new int[] {new_x, new_y, cnt+1});
        		}
        	}
        }
        queue.clear();
        visited = new boolean[maps[0].length()][maps.length];
        queue.add(new int[] {lx,ly,lcnt});
        int rx = 0;
        int ry = 0;
        int rcnt = lcnt;
        while(!queue.isEmpty()) {
        	int[] now = queue.poll();
        	int now_x = now[0];
        	int now_y = now[1];
        	int cnt = now[2];
        	if (maps[now_y].charAt(now_x) == 'E') {
        		rx = now_x;
        		ry = now_y;
        		rcnt = cnt;
        		break;
        	}
        	for (int i = 0; i < 4; i++) {
        		int new_x = now_x + X[i];
        		int new_y = now_y + Y[i];
        		if (0 <= new_x && new_x < maps[0].length() && 0 <= new_y && new_y < maps.length && !visited[new_x][new_y] && maps[new_y].charAt(new_x) != 'X') {
        			visited[new_x][new_y] = true;
        			queue.add(new int[] {new_x, new_y, cnt+1});
        		}
        	}
        }
        
        if (lcnt == 0 || lcnt == rcnt) {
        	return -1;
        }
        answer = rcnt;
        return answer;
    }
}