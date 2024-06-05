import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
        	for (int j = i + 1; j < numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        
        ArrayList<Integer> arrayList = new ArrayList<Integer>(set);
        Collections.sort(arrayList);
        
        
        
        int[] answer = new int[set.size()];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = arrayList.get(i);
        }
        
        
        return answer;
    }
}