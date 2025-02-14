import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class A {
	int idx;
	int value;

	public A(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}

	public A() {
	}
}

public class Main {

	static A[] tree;
	static int startIndex;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

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
			if (query == 1)
				change(a, b);
			else
				print(a, b);
		}
	}

	static void segmentTree(int N) throws IOException {
		startIndex = 1;
		while (startIndex < N)
			startIndex *= 2;
		tree = new A[startIndex * 2];
		for (int i = 1; i < tree.length; i++)
			tree[i] = new A(0, Integer.MAX_VALUE);
		startIndex--; // 스타트 인덱스 위치 맞춤
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i + startIndex].idx = i;
			tree[i + startIndex].value = Integer.parseInt(st.nextToken());
		}
		for (int i = startIndex; i > 0; i--) {
			if (tree[2 * i].value > tree[2 * i + 1].value) {
				tree[i] = new A(tree[2 * i + 1].idx, tree[2 * i + 1].value);
			} else {
				tree[i] = new A(tree[2 * i].idx, tree[2 * i].value);
			}
		}
	}

	static void change(int idx, int value) {
		idx += startIndex;
		tree[idx].value = value;
		while (idx > 1) {
			idx /= 2;
			if (tree[2 * idx].value > tree[2 * idx + 1].value)
				tree[idx] = new A(tree[2 * idx + 1].idx, tree[2 * idx + 1].value);
			else
				tree[idx] = new A(tree[2 * idx].idx, tree[2 * idx].value);
		}
	}

	static void print(int a, int b) {
		int start = Math.min(a, b) + startIndex;
		int end = Math.max(a, b) + startIndex;
		A result = new A(0, Integer.MAX_VALUE);
		while (start <= end) {
			if (start % 2 == 1) {
				if (result.value > tree[start].value) {
					result = new A(tree[start].idx, tree[start].value);
				} else if (result.value == tree[start].value && result.idx > tree[start].idx) {
					result = new A(tree[start].idx, tree[start].value);
				}
				start++;
			}
			if (end % 2 == 0) {
				if (result.value > tree[end].value) {
					result = new A(tree[end].idx, tree[end].value);
				} else if (result.value == tree[end].value && result.idx > tree[end].idx) {
					result = new A(tree[end].idx, tree[end].value);
				}
				end--;
			}
			start /= 2;
			end /= 2;
		}
		System.out.println(result.idx);
	}
}