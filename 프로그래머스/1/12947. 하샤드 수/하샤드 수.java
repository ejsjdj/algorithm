class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = String.valueOf(x);
        int dNum = 0;
        for (int i = 0; i < s.length(); i++) {
        	dNum += s.charAt(i) - '0';
        }
        
        if (x % dNum == 0) answer = true;
        else answer = false;
        
        return answer;
    }
}