class Solution {
	boolean isPrime(long n) {
		if (n == 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public int solution(int n, int k) {
		int answer = 0;
		String s = Integer.toString(n, k);
		String[] strArr = s.split("0");

		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].isEmpty() && isPrime(Long.valueOf(strArr[i])))
				answer += 1;
		}
		return answer;
	}
}