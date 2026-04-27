import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (bf.readLine());
		
		int paid = Integer.parseInt(st.nextToken());
		st = new StringTokenizer (bf.readLine()); 
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer (bf.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int quantity = Integer.parseInt(st.nextToken());
			paid -= cost*quantity;
		}
		if (paid == 0) System.out.println("Yes");
		else System.out.println("No");
	}

}
