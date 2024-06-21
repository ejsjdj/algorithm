class Solution {
    public int solution(String s) {
        
        char x = 'a';
        int cntX = 0;
        int cntY = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (cntX == cntY) {
        		x = s.charAt(i);
        		cntX = 1;
        		cntY = 0;
        		cnt++;
        	} else {
        		if (s.charAt(i) == x) {
        			cntX++;
        		} else if (s.charAt(i) != x) {
        			cntY++;
        		}
        	}
        }
        
        return cnt;
    }
}