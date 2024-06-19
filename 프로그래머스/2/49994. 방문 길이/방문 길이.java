import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        int ox = 0;
        int oy = 0;
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
        	char c = dirs.charAt(i);
        	
        	if (c == 'U' && y < 10) {
        		oy = y+1;
        		y++;
        		set.add(x+" "+y+"to"+x+" "+y);
        	} else if (c == 'D' && 0 < y) {
        		oy = y-1;
        		y--;
        		set.add(x+" "+y+"to"+x+" "+y);
        	} else if (c == 'R' && x < 10) {
        		ox = x+1;
        		x++;
        		set.add(x+" "+y+"to"+x+" "+y);
        	} else if (c == 'L' && 0 < x) {
        		ox = x-1;
        		x--;
        		set.add(x+" "+y+"to"+x+" "+y);
        	}
        	answer = set.size();
        }
        
        return answer;
    }
}