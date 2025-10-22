class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 100000;
        
        while (left <= right) {
        		long total = times[0];
        		int mid = (left + right) / 2;
        		
        		int timeCur = 0;
        		int timePrev = 0;
        		
        		for (int i = 1; i < times.length; i++) {
        			timeCur = times[i];
        			timePrev = times[i - 1];
        			if (mid < diffs[i]) {
        				int diff = diffs[i] - mid;
        				total += (timeCur + timePrev) * diff + timeCur;
        			} else {
        				total += timeCur;
        			}
        		}
        		
        		if (total <= limit) {
        			answer = mid;
        			right = mid - 1;
        		}
        		else if (total > limit) left = mid + 1;
        		
        }
        return answer;
    }
}