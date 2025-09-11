import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean visited[];
	static int answer[];
	static ArrayList<Integer> A[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) 
			A[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
		}
		for (int i = 1; i <= N; i++) {
		    visited = new boolean[N + 1];
		    Queue<Integer> queue = new LinkedList<>();
		    queue.add(i);
		    visited[i] = true;
		    
		    while (!queue.isEmpty()) {
		        int now_Node = queue.poll();
		        for (int next : A[now_Node]) {
		            if (!visited[next]) {
		                visited[next] = true;
		                answer[next]++;
		                queue.add(next);
		            }
		        }
		    }
		}
		int maxVal = 0;
		for (int i = 1; i <= N; i++) {
			maxVal = Math.max(maxVal, answer[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
		    if (answer[i] == maxVal) 
		        sb.append(i).append(" ");
		}
		System.out.print(sb.toString());
	}
}