import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
    	myString += "x";
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < myString.length(); i++) {
        	if (myString.charAt(i) == 'x') {
        		list.add(cnt);
        		cnt = 0;
        	}
        	else cnt += 1;
        	
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}