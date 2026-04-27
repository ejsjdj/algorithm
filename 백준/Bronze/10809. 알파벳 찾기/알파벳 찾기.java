import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i) - 97] == -1) {
				arr[str.charAt(i) - 97] = i;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (i != 26) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.print(arr[i]);
			}
		}
	}
}