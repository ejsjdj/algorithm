import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int target = Integer.parseInt(st.nextToken());
		int cnt = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			if (gcd(Math.max(target, arr[i]), Math.min(target, arr[i])) == 1) {
				cnt++;
				sum += arr[i];
			}
		}
		
		System.out.println(sum/cnt);
		
	}
	
	static int gcd(int a, int b) {
        while (b != 0) { 
            int r = a % b; 
            a = b;         
            b = r;         
        }
        return a; 
    }
}