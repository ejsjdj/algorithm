class Solution {
	public int[] solution(long begin, long end) {
		int[] answer = new int[(int)(end - begin + 1)]; 
		
		for (int i = 0; i < end - begin + 1; i++) {
			answer[i] = largestDivisor(begin + i);
		}
		
		return answer;
	}

	public static int largestDivisor(long n) {
		if (n == 1) return 0;
		// 짝수 처리
		
		int answer = 1;
		
		long sqrt = (long) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				if (n / i > 10000000) {
					answer = i;
				} else {
					answer = (int) (n / i);
					break;
				}
			}
		}
		
		// 소수인 경우
		return answer;
	}
}