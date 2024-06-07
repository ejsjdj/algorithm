class Solution {
	boolean isPrime(int num) {
		boolean flag = true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		} 
		return flag;
	}
	public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
        	if (isPrime(i)) answer += 1;
        }
        return answer;
    }
}