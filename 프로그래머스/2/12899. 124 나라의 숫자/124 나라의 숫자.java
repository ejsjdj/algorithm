class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"}; // 나눳을때 값이 1이면 1, 2이면 2, 0이면 4
        
        while (n > 0) {
        	int remainder = n % 3;
        	n /= 3;
        	
        	if (remainder == 0) n--; // 나머지가 0이라면 3의 배수이므로 n에서 1을빼줌
        	
        	answer = numbers[remainder] + answer;
        }
        
        
        return answer;
    }
}