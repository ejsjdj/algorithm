import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] grape;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		grape = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			grape[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			grape[S].add(E);
			grape[E].add(S);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(grape[i]);
		}
		DFS(V);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(V);
	}


	static void DFS(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for (int i : grape[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}
	
	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			int now_Node = queue.poll();
			System.out.print(now_Node + " ");
			for (int i : grape[now_Node]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}