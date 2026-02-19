import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int count : hm.values()) {
            answer *= (count + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}