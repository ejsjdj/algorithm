import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        int cnt = 1;
        for (int i = 1; i < tangerine.length; i++) {
        	if (tangerine[i] == tangerine[i-1]) cnt += 1;
        	else {
        		arrayList.add(cnt);
        		cnt = 1;
        	}
        	
        	
        }
        arrayList.add(cnt);
        
        Collections.sort(arrayList, Collections.reverseOrder());
        
        for (int i = 0; i < tangerine.length; i++) {
        	k -= arrayList.get(i);
        	answer += 1;
        	if (k <= 0) break;
        }
        
        return answer;
    }
}