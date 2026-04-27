import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// sum / N = 산술평균
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
		}
		System.out.println((int) Math.round((double) sum / N));
		Arrays.sort(arr);
		System.out.println(arr[(arr.length - 1) / 2]);
		
		int[] result = new int[8001];
		
		for (int i = 0; i < N; i++) {
			result[arr[i] + 4000] += 1;
		}
		
		int temp = 0;
		int medioNum = 0;
		boolean flag = false;
		for (int i = 0; i < 8001; i++) {
			if (temp < result[i]) {
				temp = result[i];
				medioNum = i;
				flag = false;
			} else if (temp == result[i] && flag == false) {
				medioNum = i;
				flag = true;
			}
		}
		System.out.println(medioNum - 4000);
		
		System.out.println(arr[arr.length - 1]-arr[0]);
	}
}