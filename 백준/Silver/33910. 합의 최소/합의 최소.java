import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) arr[i - 1] = arr[i];
			sum += arr[i];
		}
		
		System.out.println(sum + arr[0]);
	}
}