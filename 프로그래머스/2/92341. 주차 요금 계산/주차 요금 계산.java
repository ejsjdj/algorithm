import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> out = new TreeMap<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] sArr = records[i].split(" ");
            int hour = Integer.parseInt(sArr[0].split(":")[0]);
            int min = Integer.parseInt(sArr[0].split(":")[1]);
            int time = hour * 60 + min;
            String carNum = sArr[1];
            String type = sArr[2];
            
            if(type.equals("IN")) in.put(carNum, time);
            else if(type.equals("OUT")) {
                int diff = time - in.get(carNum);
                out.put(carNum, out.getOrDefault(carNum, 0) + diff);
                in.remove(carNum);
            }
        }
     
        for(Map.Entry<String, Integer> entry : in.entrySet()) {
            int lastTime = 23 * 60 + 59;
            String carNum = entry.getKey();
            int diff = lastTime - entry.getValue();
            out.put(carNum, out.getOrDefault(carNum, 0) + diff);
        }

        int[] result = new int[out.size()]; 
        int idx = 0;
        for(Map.Entry<String, Integer> entry : out.entrySet()) {
            int time = entry.getValue();
            int amount = fees[1];
            time -= fees[0];
            
            if(time > 0) {
                int plus = time % fees[2] == 0? time / fees[2] : time / fees[2] + 1;
                amount += (plus * fees[3]);
            }
            
            result[idx++] = amount;
        }
        
        return result;
    }
}