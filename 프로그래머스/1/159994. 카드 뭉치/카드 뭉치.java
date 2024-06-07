class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {

		int left = 0;
		int right = 0;

		for (int i = 0; i < goal.length; i++) {
			boolean flag = true;

			if (cards1[left].equals(goal[i])) {
				left += 1;
				flag = false;
			}

			if (cards2[right].equals(goal[i])) {
				right += 1;
				flag = false;
			}
			if (flag)
				return "No";
		}

		return "Yes";
	}
}