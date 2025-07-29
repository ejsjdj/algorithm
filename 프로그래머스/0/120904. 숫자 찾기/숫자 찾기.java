class Solution {
    public int solution(int num, int k) {
        
        String str = String.valueOf(num);
        
        int answer = str.indexOf(String.valueOf(k));
        
        if (answer == -1) {
        	return answer = -1;
            
        } else {
        	return answer + 1;
            
        }
    }
}