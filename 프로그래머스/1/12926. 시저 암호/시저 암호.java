class Solution {
	public String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z' || 'A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
				if (s.charAt(i) + n > 'z') {
					answer += (char) (s.charAt(i) + n - 'z' + 'a' - 1);
				} else if (s.charAt(i) + n > 'Z' && s.charAt(i) < 'a') {
					answer += (char) (s.charAt(i) + n - 'Z' + 'A' - 1);
				} else {
					answer += (char) (s.charAt(i) + n);
				}
			} else
				answer += s.charAt(i);
		}

		return answer;
	}
}