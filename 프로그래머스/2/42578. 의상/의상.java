import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
        	if (hm.containsKey(clothes[i][1])) {
        		hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
        	}
        	else {
        		hm.put(clothes[i][1], 1);
        	}
        }
        
        for (Entry<String, Integer> entrySet : hm.entrySet()) {
        	answer *= (entrySet.getValue() + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}