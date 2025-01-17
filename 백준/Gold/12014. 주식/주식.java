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
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int stockCnt = Integer.parseInt(st.nextToken());
			int days = Integer.parseInt(st.nextToken());
			
			int[] stocks = new int[stockCnt];
			List<Integer> lis = new ArrayList<>();
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < stocks.length; j++) {
				stocks[j] = Integer.parseInt(st.nextToken());
				int idx = Collections.binarySearch(lis, stocks[j]);
				if (idx < 0) idx = -(idx + 1);
				if (idx == lis.size()) lis.add(stocks[j]);
				else {
					lis.set(idx, stocks[j]);
				}
			}
			System.out.println("Case #" + (i + 1));
			if (lis.size() >= days) System.out.println(1);
			else System.out.println(0);
			
			
		}
	}
}