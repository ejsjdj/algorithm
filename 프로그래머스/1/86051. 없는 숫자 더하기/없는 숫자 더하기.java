class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] N = new int[10];
        
        for (int i = 0; i < numbers.length; i++) {
        	N[numbers[i]] += 1;
        }
        
        for (int i = 0; i < N.length; i++) {
        	if (N[i] == 0) answer += i;
        }
        return answer;
    }
}