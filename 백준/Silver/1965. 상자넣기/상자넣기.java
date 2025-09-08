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
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> lis = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int input = arr[i];
			int pos = Collections.binarySearch(lis, input);
			if (pos < 0) pos = -(pos + 1);
			if (lis.size() == pos) lis.add(input);
			else lis.set(pos, input);
		}
		System.out.println(lis.size());
	}
}