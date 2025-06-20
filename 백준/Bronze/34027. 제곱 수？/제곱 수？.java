import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int data = Integer.parseInt(br.readLine());
			double value = Math.pow(data, 0.5);
			if(value == (int)value) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}