class Solution {
	int divisorCnt(int num, int limit, int power) {
		int cnt = 1;
		
		for (int i = 1; i <= num/2; i++) {
			if (num % i == 0) {
				cnt++;
			}
		}	
		return cnt > limit ? power : cnt;
	}
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
        	int cnt = divisorCnt(i, limit, power);
        	answer += cnt;
        }
        
        return answer;
    }
}