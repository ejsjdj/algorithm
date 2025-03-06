import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(br.readLine());
			}
			
			for (int j = 0; j < N; j++) {
				List<Integer> lis = new ArrayList<>();
				
				for (int k = j; k < N; k++) {
					int num = arr[k];
					
					int idx = Collections.binarySearch(lis, num);
					if (idx < 0) idx = -(idx + 1);
					if (idx == lis.size()) lis.add(num);
					else lis.set(idx, num);
					
					sum += lis.size();
				}
			}
			
			sb.append("Case #" + (i + 1) + ": " + sum).append("\n");
		}
		System.out.println(sb);
	}
}