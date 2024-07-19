import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        
        List<Integer> myNumbers = new ArrayList<>();
        List<Integer> winNumbers = new ArrayList<>();
        
        for (int i = 0; i < lottos.length; i++) {
        	if (lottos[i] != 0) myNumbers.add(lottos[i]);
        }
        for (int i = 0; i < win_nums.length; i++) {
        	winNumbers.add(win_nums[i]); 
        }
        
        int cnt = 0;
        int flex = 6 - myNumbers.size();
        for (int i = 0; i < myNumbers.size(); i++) {
        	if (winNumbers.contains(myNumbers.get(i))) cnt++;
        }
        
        int max = cnt + flex;
        int min = cnt;
        int value1 = 6;
        int value2 = 6;
        
        if (max == 6) value1 = 1;
        else if (max == 5) value1 = 2;
        else if (max == 4) value1 = 3;
        else if (max == 3) value1 = 4;
        else if (max == 2) value1 = 5;
        
        if (min == 6) value2 = 1;
        else if (min == 5) value2 = 2;
        else if (min == 4) value2 = 3;
        else if (min == 3) value2 = 4;
        else if (min == 2) value2 = 5;
        int[] answer = {value1, value2};
        
        return answer;
    }
}