import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
	Set<Integer> set = new HashSet<>();
	
	boolean isPrime(int num) {
		if (num < 2) return false;
		else if (num == 2) return true;
		else {
			boolean flag = true;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) return false;
			}
		}
		return true;
	}
	
	void checker(String now, List<Character> list, boolean[] visited) {
		int ahora = Integer.parseInt(now);
		if (!set.contains(ahora)) if (isPrime(ahora)) set.add(ahora);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				checker(now+list.get(i), list, visited);
				visited[i] = false;
			}
		}
	}
	
    public int solution(String numbers) {
        int answer = 0;
        
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length(); i++) {
        	list.add(numbers.charAt(i));
        }
        
        for (int i = 0; i < list.size(); i++) {
        	boolean[] visited = new boolean[list.size()];
        	visited[i] = true;
        	checker(String.valueOf(list.get(i)), list, visited);
        	visited[i] = false;
        }
        for (int i : set) {
        	System.out.println(i);
        }
        answer = set.size();
        return answer;
        
    }
}