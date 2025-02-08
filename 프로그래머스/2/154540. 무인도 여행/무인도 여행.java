import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	
	int[] moveX = {-1, 0, 1, 0};
	int[] moveY = {0, -1, 0, 1};
	
	int BES(String[] maps, boolean[][] visited, int x, int y) {
		int cnt = maps[x].charAt(y) - '0';
		for (int i = 0; i < 4; i++) {
			int newX = x + moveX[i];
			int newY = y + moveY[i];
			if (0 <= newX && newX < maps.length && 0 <= newY && newY < maps[newX].length()
					&& maps[newX].charAt(newY) != 'X' && !visited[newX][newY]) {
				visited[newX][newY] = true;
				cnt += BES(maps, visited, newX, newY);
			}
		}
		return cnt;
	}
	
    public int[] solution(String[] maps) {
        
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
        	for (int j = 0; j < maps[i].length(); j++) {
        		if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
        			visited[i][j] = true;
        			list.add(BES(maps, visited, i, j));
        		}
        	}
        }
        Collections.sort(list);
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}