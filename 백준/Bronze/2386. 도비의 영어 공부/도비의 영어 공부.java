import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String str = sc.nextLine();
			if (str.equals("#")) break;
			str = str.toLowerCase();
			int cnt = 0;
			char ch = str.charAt(0);
			str = str.substring(2);
			for (int i = 0; i < str.length(); i++) {
				if (ch == str.charAt(i)) cnt += 1;
			}
			System.out.printf("%c %d\n", ch, cnt);
		}
	}
}
