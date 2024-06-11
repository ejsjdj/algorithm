import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int temp = n;
		
		int cnt = 0;
		
		while (temp > 0) {
			cnt += 1;
			temp = temp / 10;
		}
		
		int[] arr = new int[cnt];
		
		for (int i = 0; i < cnt; i++) {
			arr[i] = n % 10;
			n = n / 10;
		}
		
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}