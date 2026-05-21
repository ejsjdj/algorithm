import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[] array, int n) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++) {
        	list.add(array[i]);
        }
        
        list.add(n);
        
        list.sort(Comparator.naturalOrder());

        int n_idx = list.indexOf(n);
        if (n_idx == 0) {
        	return list.get(1);
        } else if (n_idx == list.size() - 1) {
        	return list.get(list.size() - 2);
        } else if (n - list.get(n_idx - 1) == list.get(n_idx+1) - n) {
        	return list.get(n_idx - 1);
        }
        	else {
        	if (n - list.get(n_idx - 1) < list.get(n_idx+1) - n) return list.get(n_idx - 1);
        	else return list.get(n_idx + 1);
        }
    }
}