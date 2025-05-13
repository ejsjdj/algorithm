import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String my_string) {
    	String answer = "";
    	List<Character> usedWordList = new ArrayList<>();
    	for (int i = 0; i < my_string.length(); i++) {
    		if (usedWordList.contains(my_string.charAt(i))) continue;
    		else {
    			answer += my_string.charAt(i);
    			usedWordList.add((my_string.charAt(i)));
    		}
    	}
        return answer;
    }
}