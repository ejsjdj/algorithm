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
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> lis = new ArrayList<>();
		for (int num : arr) {
			int idx = Collections.binarySearch(lis, num, Collections.reverseOrder());
			if (idx < 0) idx = -(idx + 1);
			
			if (idx == lis.size()) lis.add(num);
			else lis.set(idx, num);
		}
		System.out.println(lis.size());
	}
}