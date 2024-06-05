class Solution {
	public int solution(int n) {
		String num = Integer.toBinaryString(n);
		int cnt = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '1')
				cnt += 1;
		}
		int new_num = n + 1;
		while (true) {
			int new_cnt = 0;
			String newString = Integer.toBinaryString(new_num);
			for (int i = 0; i < newString.length(); i++) {
				if (newString.charAt(i) == '1')
					new_cnt += 1;
			}
			if (new_cnt == cnt) return new_num;
			else new_num = new_num + 1;
		}
	}
}