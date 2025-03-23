import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int max = 0;
		int[][] arr = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 0; i < str1.length() + 1; i++) {
			arr[i][0] = 0;
		}
		
		for (int i = 0; i < str2.length() + 1; i++) {
			arr[0][i] = 0;
		}
		
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) arr[i + 1][j + 1] = arr[i][j] + 1;
				else arr[i + 1][j + 1] = Math.max(arr[i + 1][j], arr[i][j + 1]);
				max = Math.max(max, arr[i + 1][j + 1]);
			}
		}
		
		System.out.println(max);
        }
    }