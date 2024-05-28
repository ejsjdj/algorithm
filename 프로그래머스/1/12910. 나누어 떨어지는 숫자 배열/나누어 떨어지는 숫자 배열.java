import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] % divisor == 0) list.add(arr[i]);
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        if (answer.length == 0) {
        	answer = new int[1];
        	answer[0] = -1;
        }
        
        return answer;
    }
}