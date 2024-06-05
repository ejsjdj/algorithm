import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
    	int[] answer = new int[commands.length];
    	
    	for (int i = 0; i < commands.length; i++) {
        	int[] new_array = new int[commands[i][1] - commands[i][0] + 1];
        
        	for (int j = 0; j < new_array.length; j++) {
        		new_array[j] = array[j + commands[i][0]-1];
        	}
        	Arrays.sort(new_array);
        	answer[i] = new_array[commands[i][2]-1];
    	}
        return answer;
    }
}