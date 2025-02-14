import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class A {
	int value;
	int odd;
	int even;
	public A(int value, int odd, int even) {
		this.value = value;
		this.odd = odd;
		this.even = even;
	}
}

public class Main {
	
	static A[] tree;
	static int startIndex;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		segment(N);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (query == 1) change(a, b);
			else if (query == 2) printEven(a, b);
			else printOdd(a, b);
		}
	}
	
	static void segment(int N) throws IOException {
		startIndex = 1;
		while (startIndex < N) startIndex *= 2;
		tree = new A[startIndex * 2];
		for (int i = 0; i < tree.length; i++) tree[i] = new A(0, 0, 0);
		startIndex--;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());
			tree[i + startIndex].value = value;
			if (value % 2 == 0) tree[i + startIndex].even = 1;
			else tree[i + startIndex].odd = 1;
		}
		for (int i = startIndex; i > 0; i--) {
			tree[i].odd = tree[2 * i].odd + tree[2 * i + 1].odd;
			tree[i].even = tree[2 * i].even + tree[2 * i + 1].even;
		}
	}

	static void printOdd(int a, int b) {
		int s = Math.min(a, b) + startIndex;
		int e = Math.max(a, b) + startIndex;
		int result = 0;
		while (s <= e) {
			if (s % 2 == 1) result += tree[s++].odd;
			if (e % 2 == 0) result += tree[e--].odd;
			s /= 2;
			e /= 2;
		}
		System.out.println(result);
	}
	
	static void printEven(int a, int b) {
		int s = Math.min(a, b) + startIndex;
		int e = Math.max(a, b) + startIndex;
		int result = 0;
		while (s <= e) {
			if (s % 2 == 1) result += tree[s++].even;
			if (e % 2 == 0) result += tree[e--].even;
			s /= 2;
			e /= 2;
		}
		System.out.println(result);
	}

	static void change(int idx, int value) {
		idx += startIndex;
		tree[idx].value = value;
		if (tree[idx].value % 2 == 0) {
			tree[idx].even = 1;
			tree[idx].odd = 0;
		}
		if (tree[idx].value % 2 == 1) {
			tree[idx].even = 0;
			tree[idx].odd = 1;
		}
		while (idx > 1) {
			idx /= 2;
			tree[idx].even = tree[2 * idx].even + tree[2 * idx + 1].even;
			tree[idx].odd = tree[2 * idx].odd + tree[2 * idx + 1].odd;
		}
	}

}