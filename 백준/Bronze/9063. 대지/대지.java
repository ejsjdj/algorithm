import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int miny = Integer.MAX_VALUE;
		int minx = Integer.MAX_VALUE;
		int maxy = Integer.MIN_VALUE;
		int maxx = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			miny = Math.min(miny, y);
			minx = Math.min(minx, x);
			maxy = Math.max(maxy, y);
			maxx = Math.max(maxx, x);
		}
		
		System.out.println((maxy - miny) * (maxx - minx));
	}
}