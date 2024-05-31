class Solution {
    public int solution(String[] spell, String[] dic) {
        
        for (String c : dic) {
        	boolean flag = false;
        	for (String d : spell) {
        		if (c.contains(d)) flag = true;
        		else {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) return 1;
        }
        return 2;
    }
}