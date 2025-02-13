import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		start = 1;
		while (start < N) start *= 2;
		tree = new long[start * 2];
		start--;
		Arrays.fill(tree, 0);
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (query == 0) sum(a,b);
			else modify(a, b);
		}
	}
	static void sum(int a, int b) {
		int s = Math.min(a, b) + start;
		int e = Math.max(a, b) + start;
		long result = 0;
		while (s <= e) {
			if (s % 2 == 1) result += tree[s++];
			if (e % 2 == 0) result += tree[e--];
			s /= 2;
			e /= 2;
		}
		System.out.println(result);
	}
	static void modify(int a, int b) {
		int idx = a + start;
		tree[idx] = b;
		while (idx > 1) {
			idx /= 2;
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; 
		}
	}
}