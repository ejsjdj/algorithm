import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int result = countLuckyPermutations(input);
		System.out.println(result);
		sc.close();
	}
	
	public static int countLuckyPermutations(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);	// 입력 문자열 정렬
		boolean[] used = new boolean[chars.length];
		return generatePermutations(chars, "", used, '\0');
	}
	
	public static int generatePermutations(char[] chars, String current, boolean[] used, char lastChar) {
		if (current.length() == chars.length) {
			return 1;
		}
		
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
				continue;
			}
			if (current.length() > 0 && chars[i] == lastChar) {
				continue;
			}
			used[i] = true;
			count += generatePermutations(chars, current + chars[i], used, chars[i]);
			used[i] = false;
		}
		return count;
	}
}