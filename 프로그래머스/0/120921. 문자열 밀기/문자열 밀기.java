class Solution {
	public int solution(String A, String B) {
		int answer = 0;
		for (int i = 0; i < A.length(); i++) {
			String str = "";
			for (int j = A.length() - i; j < A.length(); j++) {
				str+=A.charAt(j);
			}
			
			for (int j = 0; j < A.length() - i; j++) {
				str += A.charAt(j);
			}
			
			if (B.equals(str)) 
				return answer;
			answer++;
		}
		return -1;
	}
}