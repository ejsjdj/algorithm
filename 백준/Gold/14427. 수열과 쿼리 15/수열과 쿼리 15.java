import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class A {
	int idx = Integer.MAX_VALUE;
	int value = Integer.MAX_VALUE;
	
	public A() {}
	
	public A(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}

public class Main {
	
	static BufferedReader br;
	static StringTokenizer st;
	static A[] tree;
	static int startIndex;
	
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
			if (query == 2) print();
			else {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(idx, value);
			}
		}
	}
	
	static void segmentTree(int N) throws IOException {
		startIndex = 1;
		while (startIndex < N) startIndex *= 2;
		tree = new A[startIndex * 2];
		startIndex--;
		for (int i = 0; i < tree.length; i++) tree[i] = new A();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i + startIndex] = new A(i, Integer.parseInt(st.nextToken()));
		}
		for (int i = startIndex; i > 0; i--) {
			if (tree[2 * i].value > tree[2 * i + 1].value) {
				tree[i].idx = tree[2 * i + 1].idx;
				tree[i].value = tree[2 * i + 1].value;
			} else {
				tree[i].idx = tree[2 * i].idx;
				tree[i].value = tree[2 * i].value;
			}
		}
	}
	
	static void update(int idx, int value) {
		idx = idx + startIndex;
		tree[idx].value = value;
		while (idx > 1) {
			idx /= 2;
			if (tree[2 * idx].value > tree[2 * idx + 1].value) {
				tree[idx].value = tree[2 * idx + 1].value;
				tree[idx].idx = tree[2 * idx + 1].idx;
			} else {
				tree[idx].value = tree[2 * idx].value;
				tree[idx].idx = tree[2 * idx].idx;
			}
		}
	}
	
	static void print() {
		System.out.println(tree[1].idx);
	}
	
}