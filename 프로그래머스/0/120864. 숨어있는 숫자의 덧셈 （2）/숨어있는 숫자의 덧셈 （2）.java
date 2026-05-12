class Solution {
    public int solution(String my_string) {
        int answer = 0;
    	int tmp = 0;
    	
        for (int i = 0; i < my_string.length(); i++) {
        	char ch  = my_string.charAt(i);
        	if (Character.isDigit(ch)) {
        		tmp = tmp * 10 + Character.getNumericValue(ch);
        	} else {
        		answer += tmp;
        		tmp = 0;
        	}
        }
        if (tmp != 0) answer += tmp;
        return answer;
    }
}