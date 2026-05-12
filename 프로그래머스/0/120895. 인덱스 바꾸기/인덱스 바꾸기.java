class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        answer += my_string.substring(0, num1) + 
        		String.valueOf(my_string.charAt(num2)) + 
        		my_string.substring(num1+1,num2) + 
        		String.valueOf(my_string.charAt(num1)) + 
        		my_string.substring(num2+1, my_string.length());
    	
        return answer;
    }
}