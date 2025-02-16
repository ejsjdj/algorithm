import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt1 = 0;
		int cnt2 = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		for (int i = 0; i < input.length(); i++) {
			if (!flag1) {
				if (input.charAt(i) == '0') {
					flag1 = true;
					cnt1 += 1;
					flag2 = false;
				}
			}
			if (!flag2) {
				if (input.charAt(i) == '1') {
					flag2 = true;
					cnt2 += 1;
					flag1 = false;
				}
			}
		}
		System.out.println(Math.min(cnt1, cnt2));
	}	
}