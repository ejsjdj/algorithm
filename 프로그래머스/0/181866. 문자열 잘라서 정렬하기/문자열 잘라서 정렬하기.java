import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String myString) {
    	String[] myStringArr = myString.split("x");
        
    	List<String> list = new ArrayList<>();
    	
    	for (String i : myStringArr) {
    		if (i.equals("")) continue;
    		else list.add(i);
    	}
    	
    	String[] answer = new String[list.size()];
    	
    	for (int i = 0; i < list.size(); i++) {
    		answer[i] = list.get(i);
    	}
    	
    	Arrays.sort(answer);
    	
        return answer;
    }
}