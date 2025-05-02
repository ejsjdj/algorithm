import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        List<Integer> arr = new ArrayList<Integer>();
        
        for (int i = n; i < num_list.length; i++) {
            arr.add(num_list[i]);
        }
        for (int i = 0; i < n; i++) {
            arr.add(num_list[i]);
        }
        
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}