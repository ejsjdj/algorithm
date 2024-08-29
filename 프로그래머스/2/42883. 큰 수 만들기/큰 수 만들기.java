class Solution {
    public String solution(String number, int k) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(number);
    	int cnt = 0;
    	
    	for (int i = 0; i < sb.length()-1; i++) {
    		if (i < 0) i = 0;
    		if (sb.charAt(i) < sb.charAt(i+1)) {
    			sb.deleteCharAt(i);
    			cnt++;
    			i -= 2;
    			if (cnt == k) break;
    		}
    	}
    	
    	while (cnt != k) {
    		sb.deleteCharAt(sb.length() - 1);
    		cnt++;
    	}
    	
    	return sb.toString();
    }
}