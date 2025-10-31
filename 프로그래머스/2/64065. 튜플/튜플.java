import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class A {
	int N;
	int cnt = 1;
	A(int N) {
		this.N = N;
	}
}
class Solution {
    public int[] solution(String s) {
        
        List<A> list = new ArrayList<>();
        
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] arr = s.split(",");
        
        
        
        for (int i = 0; i < arr.length; i++) {
        	int idx = -1;
        	for (int j = 0; j < list.size(); j++) {
        		if (list.get(j).N == Integer.parseInt(arr[i])) {
        			list.get(j).cnt++;
        			idx = j;
        			break;
        		}
        	}
        	if (idx == -1) {
        		list.add(new A(Integer.parseInt(arr[i])));
        	}
        }
        
        Collections.sort(list, (o1, o2) -> o2.cnt - o1.cnt);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i).N;
        }
        return answer;
    }
}