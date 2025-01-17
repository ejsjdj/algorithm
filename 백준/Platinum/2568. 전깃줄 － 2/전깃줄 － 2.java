import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[500001];
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		
		List<Integer> lis = new ArrayList<>();
		int[] idxArr = new int[500001];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 0) {
				int idx = Collections.binarySearch(lis, arr[i]);
				if (idx < 0) idx = -(idx + 1);
				if (lis.size() == idx) {
					lis.add(arr[i]);
					idxArr[i] = idx + 1;
				} else {
					lis.set(idx, arr[i]);
					idxArr[i] = idx + 1;
				}
			}
		}
		System.out.println(N - lis.size());
		
		List<Integer> answer = new ArrayList<>();
		int idx = lis.size();
		for (int i = arr.length - 1; i > 0; i--) {
			if (idxArr[i] == idx) {
				idx--;
			} else {
				if (idxArr[i] != 0) {
					answer.add(i);
				}
			}
		}
		
		for (int i = answer.size() - 1; i >= 0; i--) {
			System.out.print(answer.get(i) + " ");
		}
	}
}