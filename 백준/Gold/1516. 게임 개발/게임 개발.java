import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
			A.add(new ArrayList<>());
		}
		
		int[] selfBuild = new int[N + 1];
		int[] indegree = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int k = Integer.parseInt(st.nextToken());
				if (k == -1) break;
				else {
					indegree[i]++;
					A.get(k).add(i);
				}
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		int[] result = new int[N+1];
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int need : A.get(now)) {
				indegree[need]--;	// 해당 건물을 짓는데 필요한 건물의 
				
				result[need] = Math.max(result[need], result[now] + selfBuild[now]);
				if (indegree[need] == 0) {
					queue.add(need);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}
}