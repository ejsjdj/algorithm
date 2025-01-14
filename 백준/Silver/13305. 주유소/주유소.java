import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long gas;
		long pay = 0;
		int[] cities  = new int[N];
		int[] distance = new int[N - 1];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < cities.length; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}
		
		gas = cities[0];
		int pos = 1;
		while (pos != N) {
			pay += gas * distance[pos - 1];
			if (gas > cities[pos]) {
				gas = cities[pos];
			} 
			pos++;
		}
		
		System.out.println(pay);
	}
}