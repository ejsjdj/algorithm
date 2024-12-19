import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) sb.append(Character.toLowerCase(ch));
			else sb.append(Character.toUpperCase(ch));
		}
		System.out.println(sb);
		sc.close();
		
	}
}