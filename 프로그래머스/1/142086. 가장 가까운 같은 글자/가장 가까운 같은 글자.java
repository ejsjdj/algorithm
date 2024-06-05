import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
    	ArrayList<Integer> arrayList = new ArrayList<>();
    	for (int i = 0; i < s.length(); i++) {
    		char ch1 = s.charAt(i);
    		int dif = -1;
    		for (int j = 0; j < i; j++) {
    			char ch2 = s.charAt(j);
    			if (ch2 == ch1) {
    				dif = i - j;
    			}
    		}
    		arrayList.add(dif);
    	}
    	
    	
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = arrayList.get(i);
        }
        return answer;
    }
}