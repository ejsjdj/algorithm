import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str1 = bf.readLine();
		String str2 = bf.readLine();
		
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} 
				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}
}