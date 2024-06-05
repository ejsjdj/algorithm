import java.util.Arrays;

class Solution {
	
	int compareTok(String str1, String str2, int k) {
		
		if (str1.charAt(k) < str2.charAt(k)) {
			return 1;
		} else if (str1.charAt(k) > str2.charAt(k)) {
			return -1;
		} else  return 0;
	}
	
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings);
        
        for (int i = 0; i < strings.length - 1; i++) {
        	for (int j = i + 1; j < strings.length; j++) { 
        		if (compareTok(strings[i], strings[j], n) == -1) {
        			String tmp = strings[i];
        			strings[i] = strings[j];
        			strings[j] = tmp;
        		}
        		if (compareTok(strings[i], strings[j], n) == 0) {
        			if (strings[i].compareTo(strings[j]) > 0) {
        				String tmp = strings[i];
            			strings[i] = strings[j];
            			strings[j] = tmp;
        			}
        		}
        	}
        }
        return strings;
    }
}