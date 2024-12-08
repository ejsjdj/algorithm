import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		str = str.toUpperCase();
		int[] arr = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++; 
		}
		
		int max = -1;
		char ch = '?';
		
		for (int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				ch = (char)(i + 65);
			}
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}
}