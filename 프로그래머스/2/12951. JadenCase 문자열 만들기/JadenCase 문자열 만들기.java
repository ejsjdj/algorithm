class Solution {
    public String solution(String s) {
        if (s == null || s.isEmpty()) {
        	return "";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (char c : s.toCharArray()) {
        	if (Character.isWhitespace(c)) {
        		sb.append(c);
        		capitalizeNext = true;
        	} else if (capitalizeNext) {
        		sb.append(Character.toUpperCase(c));
        		capitalizeNext = false;
        	} else {
        		sb.append(Character.toLowerCase(c));
        	}
        }
        
        
        return sb.toString();
    }
}