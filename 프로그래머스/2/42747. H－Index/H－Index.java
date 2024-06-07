import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < citations[citations.length - 1]; i++) {
			cnt = 0;
			for (int j = 0; j < citations.length; j++) {
				if (i <= citations[j]) cnt++;
			}
			if (cnt >= i) max = i;
		}
		return max;

	}
}