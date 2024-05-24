import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
    		list.add(arr[i]);
    	}
    	for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
    		list.add(arr[i]);
    	}
    	
    	int[] answer = new int[list.size()];
    	
    	for (int i = 0; i < answer.length; i++) {
    		answer[i] = list.get(i);
    	}
    	
        return answer;
    }
}