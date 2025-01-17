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
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int idx = Collections.binarySearch(list, arr[i]);
			if (idx < 0) idx = -(idx + 1);
			if (list.size() == idx) list.add(arr[i]);
			else {
				list.set(idx, arr[i]);
			}
		}
		
		bf.close();
		
		System.out.println(list.size());
	}
}