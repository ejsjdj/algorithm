class Solution {
    public int solution(int n) {
    	int i = 1;
    	while (true) {
    		if (i * 6 % n == 0) break;
    		i += 1;
    	}
        int answer = i;
        return answer;
    }
}