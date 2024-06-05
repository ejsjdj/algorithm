class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
        	int n = 1;
        	for (int j = 1; j <= i/2; j++) {
        		if (i % j == 0) n += 1;
        	}
        	if (n % 2 == 0) answer += i;
        	else if (n % 2 == 1) answer -= i;
        }
        return answer;
    }
}