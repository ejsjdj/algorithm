import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        int cnt = 0;
        while (true) {
        	for (int i = idx; i < progresses.length; i++) {
        		progresses[i] += speeds[i];
        	}
        	while (true) {
        		if (idx != progresses.length && progresses[idx] >= 100) {
        			cnt += 1;
        			idx += 1;
        		} else {
        			if (cnt != 0) {
        				list.add(cnt);
        				cnt = 0;
        			}break;
        		}
        	}
    		if (idx == progresses.length) break;
        }
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }

        return answer;
    }
}