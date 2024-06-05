class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') n += 1;
        	else if (s.charAt(i) == ')') {
        		n -= 1;
        		if (n < 0) {
        			break;
        		}
        	}
        }
        if (n != 0) answer = false;
        return answer;
    }
}