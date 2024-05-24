class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int action = 0;
        for (int i = 0; i < numLog.length-1; i++) {
        	action = numLog[i+1] - numLog[i];
        	if (action == 1) answer += "w";
        	if (action == -1) answer += "s";
        	if (action == 10) answer += "d";
        	if (action == -10) answer += "a";
        }
        
        return answer;
    }
}