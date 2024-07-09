import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[6];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		for (int i = 0; i < 6; i++) {
			sum += arr[i]/T;
			if (arr[i]%T > 0) sum+=1;
		}
		System.out.println(sum);
		System.out.println(N / P + " " + N % P);
		
	}
}