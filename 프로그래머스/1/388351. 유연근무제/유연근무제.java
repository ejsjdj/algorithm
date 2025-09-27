
import java.util.Arrays;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
//    	1 ≤ schedules의 길이 = n ≤ 1,000
//    	schedules[i]는 i + 1번째 직원이 설정한 출근 희망 시각을 의미합니다.
//    	700 ≤ schedules[i] ≤ 1100
//    	1 ≤ timelogs의 길이 = n ≤ 1,000
//    	timelogs[i]의 길이 = 7
//    	timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미합니다.
//    	600 ≤ timelogs[i][j] ≤ 2359
//    	1 ≤ startday ≤ 7
//    	1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일에 이벤트를 시작했음을 의미합니다.
    	
    	int[] timeLimit = new int[schedules.length];
    	for (int i = 0; i < schedules.length; i++) {
    		int schedule = schedules[i];
    		int hour = schedule/100;
    		int minutes = schedule%100;
    		minutes = minutes + 10;
    		if (minutes >= 60) {
    			hour += 1;
    			minutes %= 60;
    		}
    		timeLimit[i] = hour * 100 + minutes;
    	}
    	
    	boolean[] result = new boolean[schedules.length];
    	Arrays.fill(result, true);
    	for (int i = 0; i < 7; i++) {
    		if (startday == 6 || startday == 7) {
    			
    		}
    		else {    			
    			for (int j = 0; j < timelogs.length; j++) {
    				int arrest = timelogs[j][i];
    				if (arrest > timeLimit[j]) result[j] = false;
    			}
    		}
    		startday++;
    		if (startday > 7) startday -= 7;
    	}
    	int answer = 0;
    	for (int i = 0; i < result.length; i++) {
    		if (result[i]) answer++;
    	}
        return answer;
    }
}