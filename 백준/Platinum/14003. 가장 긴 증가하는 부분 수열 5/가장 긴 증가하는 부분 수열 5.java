import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] idxArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> lis = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int idx = Collections.binarySearch(lis, arr[i]);
			if (idx < 0) idx = -(idx + 1);
			if (idx == lis.size()) {
				idxArr[i] = lis.size();
				lis.add(arr[i]);
			} else {
				lis.set(idx, arr[i]);
				idxArr[i] = idx;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int idx = lis.size() - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (idxArr[i] == idx) {
				stack.add(arr[i]);
				idx--;
			}
		}
		
		System.out.println(lis.size());
		for (int i = 0; i < lis.size(); i++) {
			System.out.print(stack.pop() + " ");
		}
		br.close();
	}
}