import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
        	char c = dirs.charAt(i);
        	int nx = x;
            int ny = y;
        	if (c == 'U' && y < 5) {
        		y++;
        	} else if (c == 'D' && -5 < y) {
        		y--;
        	} else if (c == 'R' && x < 5) {
        		x++;
        	} else if (c == 'L' && -5 < x) {
        		x--;
        	}
        	
        	if (nx != x || ny != y) {
        		String path1 = nx +","+ny+"-"+x+","+y;
        		String path2 = x +","+y+"-"+nx+","+ny;
        		if (!set.contains(path1) && !set.contains(path2)) { 
        			set.add(path1);
        			set.add(path2);
        			answer++;
        		}
        	}
        }
        return answer;
    }
}