import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1001];
		
		int idx = 1;
		int num = 1;
		
		while (idx < arr.length) {
			for(int i = 1; i <= num; i++) {
				if(idx > 1000) {
					break;
				}
				arr[idx++] = num;
			}
			num++;
		}
		
		int answer = 0;
		for(int i = A; i <= B; i++) {
			answer += arr[i];
		}
		
		System.out.println(answer);
		br.close();
	}
}