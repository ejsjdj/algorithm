import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws  IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> cards = new HashMap<>();
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			cards.put(card, cards.getOrDefault(card, 0)+1);
		}
		
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			sb.append(cards.getOrDefault(card, 0) + " ");
		}
		System.out.println(sb.toString().trim());
		bf.close();
	}
}