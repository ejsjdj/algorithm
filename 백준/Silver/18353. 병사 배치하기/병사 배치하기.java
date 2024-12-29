import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(N - lis(arr));
		
		br.close();
	}
	
	static int lis(int[] arr) {
		
		List<Integer> lis = new ArrayList<>();
		
		for (int n : arr) {
			int idx = Collections.binarySearch(lis, n, Collections.reverseOrder());
			if (idx < 0) idx = -(idx + 1);
			if (idx == lis.size()) lis.add(n);
			else lis.set(idx, n);
		}
		
		return lis.size();
	}
}