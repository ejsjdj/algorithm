import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stkList = new ArrayList<>();
        for (int i = 0; i < arr.length;) {
            if (stkList.size() == 0) {
            	stkList.add(arr[i]);
            	i++;
            }
            else if (stkList.get(stkList.size() - 1) < arr[i]) {
            	stkList.add(arr[i]);
            	i++;
            }
            else if (stkList.get(stkList.size() - 1) >= arr[i]) {
            	stkList.remove(stkList.size() - 1);
            }
        }
        
        int[] stk = new int[stkList.size()];
        for (int i = 0; i < stk.length; i++) {
        	stk[i] = stkList.get(i);
        }
                            
        
        return stk;
    }
}