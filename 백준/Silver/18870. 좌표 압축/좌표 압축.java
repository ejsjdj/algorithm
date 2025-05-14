import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			set.add(num);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : set) {
			pq.add(i);
		}
		List<Integer> lis = new ArrayList<>();
		for (int i = 0; i < set.size(); i++) {
			lis.add(pq.poll());
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Collections.binarySearch(lis, arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}