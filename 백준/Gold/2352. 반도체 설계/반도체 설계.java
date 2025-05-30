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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		List<Integer> lis = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++ ) arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < arr.length; i++) {
			int idx = Collections.binarySearch(lis, arr[i]);
			if (idx < 0) idx = -(idx + 1);
			if (idx == lis.size()) lis.add(arr[i]);
			else lis.set(idx, arr[i]);
		}
		
		System.out.println(lis.size());
		
	}
}