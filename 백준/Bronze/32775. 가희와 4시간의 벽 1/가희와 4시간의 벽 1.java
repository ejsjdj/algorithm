import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int F = Integer.parseInt(st.nextToken());
		
		if (S <= 4) System.out.println("high speed rail");
		else if (S <= F) System.out.println("high speed rail");
		else System.out.println("flight");
		
		bf.close();
	}
}
