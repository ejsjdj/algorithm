import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] solution(int n) {
    	
    	List<Integer> list = new ArrayList<>();
    	while (n != 1) {
    		for (int i = 2; i <= n; i++) {
    			if (n % i == 0) {
    				list.add(i);
    				n = n / i;
    				break;
    			}
    		}
    	}
    	
    	
    	Set<Integer> set = new HashSet<>(list);
    	List<Integer> newList = new ArrayList<>(set);
    	
    	int[] answer = new int[newList.size()];
    	
    	for (int i = 0; i < answer.length; i++) {
    		answer[i] = newList.get(i);
    	}
    	
    	Arrays.sort(answer);
    	
        return answer;
    }
}