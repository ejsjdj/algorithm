import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set1.add(bf.readLine());
		}
		for (int i = 0; i < M; i++) {
			set2.add(bf.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>();

		for (String name : set1) {
			if (set2.contains(name)) list.add(name);
		}
		
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}
}
