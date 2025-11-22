import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        
        for (int c : d) {
        	sum += c;
            
        	if (sum > budget) {
                break;
            }
            
        	answer++;
        }
        
        return answer;
    }
}