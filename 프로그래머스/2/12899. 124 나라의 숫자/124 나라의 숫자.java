import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int n) {
    	String result = "";
    	
    	List<Integer> list = new ArrayList<>();
        while (n != 0) {
        	list.add(n % 3 == 0 ? 1 : n % 3);
        	n = n / 3;
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
        	result += list.get(i);
        }
        
        return result;
    }
}