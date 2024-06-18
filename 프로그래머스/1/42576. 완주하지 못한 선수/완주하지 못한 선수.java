import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
    	
        HashMap<String, Integer> hm = new HashMap<>();
        
        String answer = "";
        
        for (int i = 0; i < participant.length; i++) {
        	if (hm.containsKey(participant[i])) hm.replace(participant[i],hm.get(participant[i])+1);
        	else hm.put(participant[i], 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
        	hm.replace(completion[i], hm.get(completion[i])-1);
        }
        
        for (int i = 0; i < participant.length; i++) {
        	if (hm.get(participant[i]) == 1) {
        		answer = participant[i];
        		break;
        	}
        }
        return answer;
    }
}