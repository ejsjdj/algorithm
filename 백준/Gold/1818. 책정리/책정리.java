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
		st = new StringTokenizer(br.readLine());
		List<Integer> lis = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int book = Integer.parseInt(st.nextToken());
			int idx = Collections.binarySearch(lis, book);
			if (idx < 0) idx = -(idx + 1);
			if (lis.size() == idx) lis.add(book);
			else lis.set(idx, book);
		}
		System.out.println(N - lis.size());
	}
}