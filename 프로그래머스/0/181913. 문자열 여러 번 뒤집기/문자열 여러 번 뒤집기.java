class Solution {
	
	String wordMaker(String my_string, int start, int end) {
		String new_string = "";
		
		for (int i = 0; i < start; i++) {
			new_string += String.valueOf(my_string.charAt(i));
		}
		for (int i = end; i >= start; i--) {
			new_string += String.valueOf(my_string.charAt(i));
		}
		for (int i = end+1; i < my_string.length(); i++) {
			new_string += String.valueOf(my_string.charAt(i));
		}
		
		return new_string;
	}
	
    public String solution(String my_string, int[][] queries) {
        
        for (int i = 0; i < queries.length; i++) {
        	my_string = wordMaker(my_string, queries[i][0], queries[i][1]);
        }
        
        return my_string;
    }
}