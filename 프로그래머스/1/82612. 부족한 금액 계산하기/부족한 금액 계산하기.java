class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        for (int i = 0; i < count; i++) {
        	total = total + (price * (i + 1));
        }
        
        answer = total - money;
        
        if (answer < 0) answer = 0;
        
        return answer;
    }
}