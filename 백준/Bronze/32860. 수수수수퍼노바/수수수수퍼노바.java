import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int div = (M-1)/26;
		int mod = (M-1)%26;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SN");
		sb.append(" ");
		sb.append(N);
		
		if (div != 0) {
			int intValue = 97 + div-1;
			char A = (char) intValue;
			intValue = 97 + mod;
			char B =  (char) intValue;
			sb.append(A);
			sb.append(B);
		} else {
			int intValue = 65 + mod;
			char B = (char) intValue;
			sb.append(B);
		}
		
		System.out.println(sb);
		sc.close();
		
	}
}
