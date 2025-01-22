import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 원소의 수
			int[] arr = new int[N + 1];
			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(lis(arr));
		}
		
	}
	
	static int lis (int[] arr) {
		List<Integer> lis = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			int idx = Collections.binarySearch(lis, arr[i]);
			if (idx < 0) idx = -(idx + 1);
			if (lis.size() == idx) lis.add(arr[i]);
			else lis.set(idx, arr[i]);
		}
		return lis.size();
	}
}