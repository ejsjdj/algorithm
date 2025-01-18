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
		
		while (true) {
			String str = br.readLine();
			if (str == null || str.trim().isBlank()) break;
			StringTokenizer st = new StringTokenizer(str);
			int len = Integer.parseInt(st.nextToken());
			int[] arr = new int[len];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			List<Integer> lis = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				int idx = Collections.binarySearch(lis, arr[i]);
				if (idx < 0)
					idx = -(idx + 1);
				if (lis.size() == idx)
					lis.add(arr[i]);
				else
					lis.set(idx, arr[i]);
			}
			System.out.println(lis.size());
		}
	}
}