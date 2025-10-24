import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        
        int[] wanho = {scores[0][0], scores[0][1]};
        
        Arrays.sort(scores, (o1, o2) -> {
        		if (o1[0] != o2[0]) return o2[0] - o1[0];
        		return o1[1] - o2[1];
        });
        
        int max = scores[0][1];
        
        for (int i = 1; i < scores.length; i++) {
        		if (scores[i][1] < max) {
        			scores[i][0] = -1;
        			scores[i][1] = -1;
        		} else {
        			max = scores[i][1];
        		}
        }
        
        Arrays.sort(scores, (o1, o2) -> {
        		return o2[0] + o2[1] - o1[0] - o1[1];
        });
        int[] result = new int[scores.length];
        result[0] = 1;
        if (scores[0][0] == wanho[0] && scores[0][1] == wanho[1]) return result[0];
        for (int i = 1; i < scores.length; i++) {
        		if ((scores[i][0] + scores[i][1]) == (scores[i - 1][0] + scores[i - 1][1])) result[i] = result[i - 1];
        		else result[i] = i + 1;
        		if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) return result[i];
        }
        
        return answer;
    }
}