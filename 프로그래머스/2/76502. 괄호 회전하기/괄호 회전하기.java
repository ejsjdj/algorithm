import java.util.Stack;

class Solution {
	boolean checker(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) return false;
				if (s.charAt(i) == ')') {
					if (stack.peek() == '(') stack.pop();
					else return false;
				}
				if (s.charAt(i) == '}') {
					if (stack.peek() == '{') stack.pop();
					else return false;
				}
				if (s.charAt(i) == ']') {
					if (stack.peek() == '[') stack.pop();
					else return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;

	}

	public int solution(String s) {
		int answer = 0;
		String str = s;
		for (int i = 0; i < s.length(); i++) {
			str = s.substring(i, s.length()) + s.substring(0, i);
			if (checker(str))
				answer += 1;
		}
		return answer;
	}
}