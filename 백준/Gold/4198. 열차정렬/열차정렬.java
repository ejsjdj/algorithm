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
		List<Integer> lis = new ArrayList<>();
		List<Integer> lds = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int[][] answerSet = new int[N+1][2]; 
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i > 0; i--) {
			lis = new ArrayList<>();
			lds = new ArrayList<>();
			lis.add(arr[i]);
			lds.add(arr[i]);
			for (int j = i + 1; j <= N; j++) {
				int idx = Collections.binarySearch(lis, arr[j]);
				if (idx < 0) idx = -(idx + 1);
				if (idx == lis.size()) lis.add(arr[j]);
				else if (idx != 0) lis.set(idx, arr[j]);
			}
			answerSet[i][0] = lis.size();
			for (int j = i + 1; j <= N; j++) {
				int idx = Collections.binarySearch(lds, arr[j], Collections.reverseOrder());
				if (idx < 0) idx = -(idx + 1);
				if (idx == lds.size()) lds.add(arr[j]);
				else if (idx != 0) lds.set(idx, arr[j]);
			}
			answerSet[i][1] = lds.size();
		}
		int resp = 0;
		for (int i = 1; i <= N; i++) {			
			resp = Math.max(resp, answerSet[i][0] + answerSet[i][1] - 1);
		}
		System.out.println(resp);
	}
}