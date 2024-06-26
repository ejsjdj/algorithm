import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Tower {
	int N;
	Set<Integer> set = new HashSet<>();
	public Tower(int n) {
		N = n;
	}
}

class Solution {
	public int counter(Tower[] arr, int a, int b) {
		int cntA = 0;
		int cntB = 0;
		boolean[] visited = new boolean[arr.length+1];
		
		Queue<Tower> queue = new LinkedList<>();
		queue.add(arr[a]);
		visited[a] = true;
		cntA = 1;
		while (!queue.isEmpty()) {
			Tower now = queue.poll();
			for (int i : now.set) {
				if (!visited[i]) {
					visited[i] = true;
					cntA++;
					queue.add(arr[i]);
				}
			}
		}
		
		queue.add(arr[b]);
		visited[b] = true;
		cntB = 1;
		while (!queue.isEmpty()) {
			Tower now = queue.poll();
			for (int i : now.set) {
				if (!visited[i]) {
					visited[i] = true;
					cntB++;
					queue.add(arr[i]);
				}
			}
		}
		return Math.abs(cntA - cntB);
	}
	
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        Tower[] arr = new Tower[n+1];
        
        for (int i = 1; i <= n; i++) {
        	arr[i] = new Tower(i);
        }
        
        for (int i = 0; i < wires.length; i++) {
        	int[] now = wires[i];
        	int a = now[0];
        	int b = now[1];
        	arr[a].set.add(b);
        	arr[b].set.add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
        	int[] now = wires[i];
        	int a = now[0];
        	int b = now[1];
        	arr[a].set.remove(b);
        	arr[b].set.remove(a);
        	answer = Math.min(answer, counter(arr, a, b));
        	arr[a].set.add(b);
        	arr[b].set.add(a);
        }
        
        return answer;
    }
}