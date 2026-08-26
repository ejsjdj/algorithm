class Solution {
    public int solution(int[][] signals) {
        int answer = -1;

        int len = 1;

        for (int i = 0; i < signals.length; i++) {
            len = 20 * len;
        }

        for (int i = 1; i <= len; i++) {
            boolean flag = true;
            for (int j = 0; j < signals.length; j++) {
                int G = signals[j][0];
                int Y = signals[j][1];
                int R = signals[j][2];

                int rest = i % (G + Y + R);
                if (G < rest && rest <= G + Y) {
                    continue;
                }
                else {
                    flag = false;
                }
            }
            if (flag) return i;
        }

        return answer;
    }
}