class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        
        // a와 b가 같지 않을 때까지 반복
        while (a != b) {
            // 다음 라운드의 번호 계산
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        
        return round;
    }
}