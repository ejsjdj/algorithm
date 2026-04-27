import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int num2 = Integer.parseInt(st.nextToken());
		
		int 등차수열일때의_차 = num2 - num1;
		int 등비수열일때의_차 = num2 / num1;
		
		
		st = new StringTokenizer(br.readLine());
			
		int num3 = Integer.parseInt(st.nextToken());
			
		int 등차수열일때의_차2 = num3 - num2;
		int 등비수열일때의_차2 = num3 / num2;
		
		if (등차수열일때의_차2 == 등차수열일때의_차) {
			for (int i = 0; i < N - 3; i ++) {
				st = new StringTokenizer(br.readLine());
			}
			br.close();
			System.out.println(num1 + (등차수열일때의_차 * (N)));
		}
		else {
			for (int i = 0; i < N - 3; i ++) {
				st = new StringTokenizer(br.readLine());
			}
			br.close();
			System.out.println((int)(num1 * Math.pow(등비수열일때의_차2,N)));
		}
	}
}