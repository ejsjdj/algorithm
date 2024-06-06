import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> scoreList = new ArrayList<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            scoreList.sort(Collections.reverseOrder());

            if (i < k) {
                answer[i] = scoreList.get(i);
            } else {
                answer[i] = scoreList.get(k - 1);
            }
        }

        return answer;
    }
}