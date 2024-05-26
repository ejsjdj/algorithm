class Solution {
    public int[] solution(int[] arr) {
        
        int n = 1;
        while (n < arr.length) {
        	n *= 2;
        }
        
        int[] answer  = new int[n];
        int dif = answer.length - arr.length;
        
        for (int i = 0; i < arr.length; i++) {
        	answer[i] = arr[i];
        }
        
        for (int i = answer.length - dif; i < answer.length; i++) {
        	answer[i] = 0;
        }
        
        return answer;
    }
}