class Solution {
    public String solution(int n) {
        String answer = "";
        int i = 0;
        while (true) {
        	if (i >= n) break;
        	answer += "수";
        	i++;
        	if (i >= n) break;
        	answer += "박";
        	i++;
        }
        	
        return answer;
    }
}