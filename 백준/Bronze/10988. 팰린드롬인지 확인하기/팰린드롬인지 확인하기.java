import java.util.Scanner;

public class Main {
	static int val(String st) {
		for (int i = 0; i < st.length()/2; i++) {
			if (st.charAt(i) != st.charAt(st.length() - 1 - i)) return 0;
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		
		System.out.println(val(st));
		sc.close();
	}
	
}
