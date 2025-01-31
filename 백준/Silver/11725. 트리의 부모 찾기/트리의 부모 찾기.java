import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static boolean[] visited;
	static ArrayList<Integer> tree[];
	static int answer[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		answer = new int[N + 1];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		DFS(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
		sc.close();
	}
	static void DFS(int number) {
		visited[number] = true;
		for (int i : tree[number]) {
			if (!visited[i]) {
				answer[i] = number;
				DFS(i);
			}
		}
	}
}