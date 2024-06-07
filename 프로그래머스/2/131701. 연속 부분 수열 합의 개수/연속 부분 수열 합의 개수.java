import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
        	int idx = i;
        	int sum = 0;
        	while (true) {
        		sum += elements[idx];
        		hashSet.add(sum);
        		idx++;
        		if (idx == elements.length) idx = 0;
        		if (idx == i) break;
        	}
        }
        
        return hashSet.size();
    }
}