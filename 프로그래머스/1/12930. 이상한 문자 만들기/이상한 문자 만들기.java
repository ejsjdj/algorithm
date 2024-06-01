class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		answer += ' ';
        		idx = 0;
        	} else if (idx % 2 == 0) {
        		answer += Character.toUpperCase(s.charAt(i));
        		idx += 1;
        	} else if (idx % 2 == 1) {
        		answer += Character.toLowerCase(s.charAt(i));
        		idx += 1;
        	}
        }
        
        return answer;
    }
}