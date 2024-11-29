import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		// 학생의 수
		int N = Integer.parseInt(st.nextToken());
		// 컷트라인 학생의 순번
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
		
		list.sort((o1, o2) -> o2 - o1);
		System.out.println(list.get(k - 1));		
	}
}