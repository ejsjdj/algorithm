class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        
        if (r == 0) {
        	answer += code.charAt(0);
        }
        
        for (int i = 1; i < code.length(); i++) {
        	if (i % q == r) answer += code.charAt(i);
        }
        
        return answer;
    }
}