class Solution {
	boolean checker(String s) {
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (int i = 0; i < s.length()-1; i++) {
			if (a < 0 || b < 0 || c < 0) return false;
			if (s.charAt(i) == '(' ) {
				a += 1;
				if (s.charAt(i + 1) == '}' || s.charAt(i + 1) == ']') return false;
			} else if (s.charAt(i) == ')') {
				a -= 1;
			} else if (s.charAt(i) == '{') {
				b += 1;
				if (s.charAt(i + 1) == ')' || s.charAt(i + 1) == ']') return false;
			} else if (s.charAt(i) == '}') {
				b -= 1;
			} else if (s.charAt(i) == '[') {
				c += 1;
				if (s.charAt(i + 1) == '}' || s.charAt(i + 1) == ')') return false;
			} else if (s.charAt(i) == ']') {
				c -= 1;
			}
		}
		
		for (int i = s.length()-1; i < s.length(); i++) {
			if (a < 0 || b < 0 || c < 0) return false;
			if (s.charAt(i) == '(' ) {
				a += 1;

			} else if (s.charAt(i) == ')') {
				a -= 1;
			} else if (s.charAt(i) == '{') {
				b += 1;

			} else if (s.charAt(i) == '}') {
				b -= 1;
			} else if (s.charAt(i) == '[') {
				c += 1;

			} else if (s.charAt(i) == ']') {
				c -= 1;
			}
		}

		if (a == 0 && b == 0 && c == 0) return true;
		else return false;
	}
	
    public int solution(String s) {
        int answer = 0;
        String str = s;
        for (int i = 0; i < s.length(); i++) {
        	str = s.substring(i, s.length()) + s.substring(0, i);
        	if (checker(str)) answer += 1;
        }
        return answer;
    }
}