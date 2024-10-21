import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
	boolean[] visited;
	List<Set<Integer>> list;
	
	boolean check(String user_id, String banned_id) {
	    if (user_id.length() != banned_id.length()) return false;
	    for (int i = 0; i < user_id.length(); i++) {
	        if (banned_id.charAt(i) != '*' && user_id.charAt(i) != banned_id.charAt(i)) return false;
	    }
	    return true;
	}
	
	void DFS (String[] user_id, String[] banned_id, int now) {
		// banned_id 가 끝까지 돌았을 경우 list 에 값을 넣음
		if (now == banned_id.length) {
			list.add(new HashSet<Integer>());
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) list.get(list.size() - 1).add(i);
			}
			return;
		}
		
		for (int i = 0; i < user_id.length; i++) {
			if (visited[i]) continue;
			if (check(user_id[i], banned_id[now])) {
				visited[i] = true;
				DFS(user_id, banned_id, now+1);
				visited[i] = false;
			}
		}
	}
	
	public int solution(String[] user_id, String[] banned_id) {
        
        visited = new boolean[user_id.length];
        list = new ArrayList<Set<Integer>>();
        
        DFS(user_id, banned_id, 0);
        
        Set<Set<Integer>> uniqueSets = new HashSet<>(list);
        return uniqueSets.size();
    }
}