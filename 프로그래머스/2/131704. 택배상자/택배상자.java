import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		int answer = 0;

		Stack<Integer> subConveyer = new Stack<>();

		int now = 1;
		int idx = 0;
		while (true) {
			if (idx >= order.length) break;
			int need = order[idx];
			if (now == need) {
				answer++;
				idx++;
				now++;
			} else if (!subConveyer.isEmpty() && subConveyer.peek() == need) {
				answer++;
				idx++;
				subConveyer.pop();
			} else if (now > need || idx > need || idx >= order.length) {
				break;
			} else {
				subConveyer.add(now);
				now++;
			}
		}
		return answer;
	}
}