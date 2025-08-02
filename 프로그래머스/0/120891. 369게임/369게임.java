class Solution {
    public int solution(int order) {
        int answer = 0;
        while (order > 0) {
        	if (order % 10 == 3) answer += 1;
        	else if (order % 10 == 6) answer += 1;
        	else if (order % 10 == 9) answer += 1;
        	order /= 10;
        }
        return answer;
    }
}