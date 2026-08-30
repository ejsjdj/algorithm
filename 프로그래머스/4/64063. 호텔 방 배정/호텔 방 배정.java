import java.util.*;

class Solution {
    
    HashMap<Long, Long> hm;
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        hm = new HashMap<>();
        
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    long find(long d) {
        long roomNum = hm.getOrDefault(d, d);
        
        if (d == roomNum) {
            hm.put(d, roomNum + 1);
            return d;
        }
        
        long next = find(roomNum);
        hm.put(d, next);
        return next;
    }
}