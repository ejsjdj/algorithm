import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        
        List<String> list = new ArrayList<>();
        
        for (String i : strArr) {
        	if (i.contains("ad")) continue;
        	else list.add(i);
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}