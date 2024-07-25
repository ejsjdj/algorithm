import java.util.LinkedList;
import java.util.Queue;

class A {
	int x;
	int cnt;
	public A(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<A> queue = new LinkedList<>();
        if (x == y) return 0;
        if (x > y) return -1;
        queue.add(new A(x, 0));
        boolean[] visited = new boolean[y+1];
        while (!queue.isEmpty()) {
        	A a = queue.poll();
        	int now = a.x;
        	visited[now] = true;
        	int cnt = a.cnt;
        	if (now * 2 == y || now * 3 == y || now + n == y) {
        		answer = cnt+1;
        		break;
        	}
        	if (now * 2 < y && visited[now*2] == false) {
        		queue.add(new A(now * 2, cnt+1));
        		visited[now*2] = true;
        	}
        	if (now * 3 < y && visited[now*3] == false) {
        		queue.add(new A(now * 3, cnt+1));
        		visited[now*3] = true;
        	}
        	if (now + n < y && visited[now+n] == false) {
        		queue.add(new A(now + n, cnt+1));
        		visited[now+n] = true;
        	}
        }
        return answer == 0 ? -1 : answer;
    }
}