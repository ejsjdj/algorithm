import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] connections = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			connections[i][0] = Integer.parseInt(st.nextToken());
			connections[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(connections, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		
		LIS(connections);
		
	}
	
	static void LIS(int[][] connections) {
		
		List<Integer> lis = new ArrayList<>();
		
		for (int i = 0; i < connections.length; i++) {
			
			int idx = Collections.binarySearch(lis, connections[i][1]);
			
			if (idx < 0) idx = -(idx + 1);
			
			if (idx == lis.size()) lis.add(connections[i][1]);
			else {
				lis.set(idx, connections[i][1]);
			}
			
		}
		System.out.println(connections.length - lis.size());
	}
}