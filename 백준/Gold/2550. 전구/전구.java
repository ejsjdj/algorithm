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
		
		int[][] arr = new int[N+1][2];
		int[] backTracking = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			backTracking[i] = arr[i][0];
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[Integer.parseInt(st.nextToken())][1] = i;
		}
		
		List<Integer> lis = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			int idx = Collections.binarySearch(lis, arr[arr[i][0]][1]);
			if (idx < 0) idx = -(idx + 1);
			if (lis.size() == idx) lis.add(arr[arr[i][0]][1]);
			else lis.set(idx, arr[arr[i][0]][1]);
			backTracking[arr[i][0]] = idx;
		}
		System.out.println(lis.size());
		List<Integer> answer = new ArrayList<>();
		
		int idx = lis.size() - 1;
		for (int i = N; i >= 1; i--) {
			if (backTracking[arr[i][0]] == idx) {
				answer.add(arr[i][0]);
				idx--;
			}
		}
		
		Collections.sort(answer);
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		
		br.close();
	}
}