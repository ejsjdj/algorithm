import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int maxIdx = 0;
        int maxValue = 0;
        
        Arrays.sort(works);
        int[] time = new int[works.length];
        
        for (int i = 0; i < time.length; i++) {
        	time[i] = works[works.length-1-i];
        }
        
        for (int i = 0; i < n; i++) {
        	maxIdx = 0;
        	maxValue = time[maxIdx];
        	for (int j = maxIdx+1; j < time.length; j++) {
        		if (maxValue <= time[j]) {
        			maxIdx = j;
        			maxValue = time[j];
        		} else {
        			break;
        		}
        	}
        	if (maxValue == 0) break;
        	time[maxIdx] -= 1;
        }
        for (int i = 0; i < time.length; i++) {
        	System.out.print(time[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < time.length; i++) {
        	answer += time[i] * time[i];
        }
        
        return answer;
    }
}