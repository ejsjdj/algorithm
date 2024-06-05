class Solution {
	boolean solution(String s) {
		boolean answer = true;

		int p_cnt = 0;
		int y_cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p' || s.charAt(i) == 'P') p_cnt += 1;
			else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') y_cnt += 1;
		} 
		
		if (p_cnt == y_cnt || (p_cnt == 0 && y_cnt == 0)) answer = true;
		else if (p_cnt != y_cnt) answer = false;
		return answer;
	}
}