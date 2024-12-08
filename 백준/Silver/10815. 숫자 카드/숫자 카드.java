import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Set<Integer> set = new HashSet<>();
		int[] answer;
		int N;
		int M;
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			int ask = Integer.parseInt(st.nextToken());
			if (set.contains(ask)) answer[i] = 1;	
		}
		
		for (int i = 0; i < M; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}