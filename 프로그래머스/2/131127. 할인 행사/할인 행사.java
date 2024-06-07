class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		for (int i = 0; i < discount.length - 9; i++) {
			boolean flag = true;
			for (int k = 0; k < number.length; k++) {
				int cnt = 0;
				for (int j = i; j < i + 10; j++) {
					if (want[k].equals(discount[j])) cnt++;
				}
				if (number[k] != cnt) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}
			if (flag) answer += 1;
		}
		return answer;
	}
}