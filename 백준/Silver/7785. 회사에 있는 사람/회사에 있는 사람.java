import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		HashMap<String, String> hm = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			hm.put(name, state);
		}
		
		List<String> list = new ArrayList<>();
		
		for (String name : hm.keySet()) {
			if (hm.get(name).equals("enter")) list.add(name);
		}
		
		Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}