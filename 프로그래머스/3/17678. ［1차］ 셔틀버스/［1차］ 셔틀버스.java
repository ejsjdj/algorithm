import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int[] timeTable = new int[timetable.length];
        int[] bus = new int[n];
        
        for (int i = 0; i < timeTable.length; i++) {
        		String[] cru = timetable[i].split(":");
        		timeTable[i] = Integer.parseInt(cru[0]) * 60 + Integer.parseInt(cru[1]);
        }
        
        Arrays.sort(timeTable);
        
        for (int i = 0; i < n; i++) {
        	bus[i] = 60 * 9 + t * i;
        }


        int cru = 0;
        boolean cruOver = false;
        for (int i = 0; i < n - 1; i++) {
            int busTime = bus[i];
            int cnt = 0;

            // 태울수 있는경우
            while (cnt < m && busTime >= timeTable[cru]) {
                cnt++;
                cru++;
                if (cru == timeTable.length) {
                    cruOver = true;
                    break;
                }
            }
            if (cruOver) break;
        }
        boolean busIsFull = false;
        
        int busTime = bus[n - 1];
        int cnt = 0;
        for (int i = cru; i < timeTable.length; i++) {
            if (timeTable[i] <= busTime) {
                cnt++;
                if (cnt == m) {
                    busIsFull = true;
                    cru = i;
                    break;
                } else {
                    busIsFull = false;
                }
            }
        }

        if (busIsFull) {
            int time = timeTable[cru] - 1;
            int hour = time / 60;
            int minute = time % 60;
            if (hour < 10) answer = "0" + String.valueOf(hour);
            else answer += String.valueOf(hour);
            answer += ":";
            if (minute < 10) answer += "0" + String.valueOf(minute);
            else answer += String.valueOf(minute);
        }
        else {
            int time = bus[bus.length - 1];
            int hour = time / 60;
            int minute = time % 60;
            if (hour < 10) answer = "0" + String.valueOf(hour);
            else answer += String.valueOf(hour);
            answer += ":";
            if (minute < 10) answer += "0" + String.valueOf(minute);
            else answer += String.valueOf(minute);
        }

        return answer;
    }
}