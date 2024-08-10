class Solution {
	public int[] solution(int[] sequence, int k) {
		int[] answer = { 0, Integer.MAX_VALUE };

		int left = 0;
		int right = 0;
		int sum = sequence[0];
		while (true) {
			if (sum < k) {
				right += 1;
				if (right == sequence.length)
					break;
				sum += sequence[right];
			} else if (sum > k) {
				sum -= sequence[left];
				left += 1;
			} else if (sum == k) {
				if (answer[1] - answer[0] > right - left) {
					answer[0] = left;
					answer[1] = right;
				}
				right++;
				if (right == sequence.length)
					break;
				else
					sum += sequence[right];
			}
		}
		return answer;
	}
}