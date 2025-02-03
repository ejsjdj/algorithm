import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, R, Q;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[] subTreeSize;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 수
		R = Integer.parseInt(st.nextToken()); // 루트의 번호
		Q = Integer.parseInt(st.nextToken()); // 쿼리의 수

		tree = new ArrayList[N + 1];
		subTreeSize = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		DFS(R);
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int req = Integer.parseInt(st.nextToken());
			System.out.println(subTreeSize[req]);
		}
	}

	static void DFS(int root) {
		visited[root] = true;

		subTreeSize[root] = 1;
		for (int i : tree[root]) {
			if (!visited[i]) {
				DFS(i);
				subTreeSize[root] += subTreeSize[i];
			}
		}
	}
}