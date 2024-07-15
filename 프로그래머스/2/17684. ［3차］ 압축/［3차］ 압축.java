import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        String now = "";
        String word = "";
        String lastWord = "";
        int idx = 27;
        HashMap<String, Integer> hm = new HashMap<>(); 
        
        for (int i = 0; i < 26; i++) {
        	hm.put(Character.toString('A'+i), i+1);
        }
        
    	List<Integer> list = new ArrayList<>();
        for (int i = 0; i < msg.length(); i++) {
        	now = Character.toString(msg.charAt(i));	// A , K , A
        	lastWord = word;	// K , "", K
        	word = word + now;	// KA , K, 
        	if (hm.containsKey(word)) continue;
        	else {
        		list.add(hm.get(lastWord));
        		hm.put(word, idx++);
        		lastWord = "";
        		word = "";
        		i--;
        	}
        }
        
        if (!word.equals("")) list.add(hm.get(word));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}