import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> li = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
        	for (int j = 0; j < arr[i]; j++) {
        		li.add(arr[i]);
        	}
        }
        
        int[] answer = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
        	answer[i] = li.get(i);
        }
        
        return answer;
    }
}