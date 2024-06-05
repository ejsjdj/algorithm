import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        int actualNum = arr[0];
        list.add(actualNum);
        
        for (int i = 1; i < arr.length; i++) {
        	if (actualNum != arr[i]) {
        		list.add(arr[i]);
        		actualNum = arr[i];
        	}
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}