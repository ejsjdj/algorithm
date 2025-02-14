import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int startIndex;
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		segmentTree(N);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (query == 1) update(a,b);
			else print(a, b);
		}
	}
	
	static void segmentTree(int N) throws IOException {
		startIndex = 1;
		while (startIndex < N) startIndex *= 2;
		tree = new int[startIndex * 2];
		Arrays.fill(tree, Integer.MAX_VALUE);
		startIndex--; // 문제조건에 맞게 startIndex 조정
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i + startIndex] = Integer.parseInt(st.nextToken());
		}
		for (int i = startIndex; i > 0; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
	}
	
	static void update(int idx, int value) {
		idx += startIndex;
		tree[idx] = value;
		while (idx > 1) {
			idx /= 2;
			tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
		}
	}
	
	static void print(int a, int b) {
		int s = Math.min(a, b) + startIndex;
		int e = Math.max(a, b) + startIndex;
		int result = Integer.MAX_VALUE;
		while (s <= e) {
			if (s % 2 == 1) {
				result = Math.min(result, tree[s]);
				s++;
			}
			if (e % 2 == 0) {
				result = Math.min(result, tree[e]);
				e--;
			}
			s /= 2;
			e /= 2;
		}
		System.out.println(result);
	}
}