import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		String[] str = bf.readLine().split(" ");
		int sum = 0;
		int total = 0;
		
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			total += sum + arr[i];
			sum += arr[i];
		}
		
		System.out.println(total);
	}
}