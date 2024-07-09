class Solution {
    public String solution(int n, int t, int m, int p) { 
        String answer = "";
        
        String str = "";
        
        for (int i = 0; i <= t*m; i++) {
        	str += Integer.toString(i, n).toUpperCase();
        }
        for (int i = p; i <= t*m; i += m) {
        	answer += str.charAt(i-1);
        }
        return answer;
    }
}