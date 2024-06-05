
class Solution {

	int gcd(int n, int m) { // 최대 공약수
		int answer = 1;
		if (n > m) {
			for (int i = 1; i <= n; i++) {
				if (n % i == 0 && m % i == 0) {
					answer = i;
				}
			}
		} else {
			for (int i = 1; i <= m; i++) {
				if (n % i == 0 && m % i == 0) {
					answer = i;
				}
			}
		}
		return answer;
	}

	int lcm(int n, int m) { // 최소 공배수
		int answer = 0;
		if (n < m) {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				if (n * i % m == 0) {
					answer = i * n;
					break;
				}
			}
		} else {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				if (m * i % n == 0) {
					answer = i * m;
					break;
				}
			}
		}
		return answer;
	}

	public int[] solution(int n, int m) {

		int a = gcd(n, m);
		int b = lcm(n, m);

		int[] answer = new int[2];
		answer[0] = a;
		answer[1] = b;
		return answer;
	}
}