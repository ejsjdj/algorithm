class Solution {
	public int solution(int a, int b) {
		
		int max = 0;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				max = i;
			}
		}
		
		b = b / max;
		
		while (true) {
			if (b % 2 == 0) {
				b = b / 2;
			}
			else if (b % 5 == 0) {
				b = b / 5;
			} else {
				break;
			}
		}
		if (b == 1) return 1;
		else return 2;
	}
}