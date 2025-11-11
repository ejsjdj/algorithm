import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
        	if (o1[1] == o2[1]) return o2[0] - o1[0];
        	return o1[1] - o2[1];
        });
        
        int e = targets[0][1];
        answer++;
        
        for (int i = 0; i < targets.length; i++) {

        	int s = targets[i][0];
        	
        	if (s < e) continue;
        	
        	else {
        		answer++;
        		e = targets[i][1];
        	}
        	
        }
        
        return answer;
    }
}