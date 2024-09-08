import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < times.length; i++) {
        	for (int j = 0; j < 2; j++) {
        		int hour = (Integer.parseInt(book_time[i][j].split(":")[0]) * 60);
        		int minute = Integer.parseInt(book_time[i][j].split(":")[1]);
        		times[i][j] = hour + minute;
        	}
        }
        
        Arrays.sort(times, (o1, o2) -> {
        	if (o1[0] - o2[0] > 0) return 1;
        	else if (o1[0] - o2[0] < 0) return -1;
        	else {
        		if (o1[1] - o2[1] > 0) return 1;
        		else return -1;
        	}
        });
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < times.length; i++) {
        	int now = times[i][0];
        	boolean flag = true;
        	
        	for (int j = 0; j < list.size(); j++) {
        		if (list.get(j)[1] + 10 <= now) {
        			list.remove(j);
        			list.add(times[i]);
        			flag = false;
        			break;
        		}
        	}
        	if (flag) list.add(times[i]);
        }
        
        return list.size();
    }
}