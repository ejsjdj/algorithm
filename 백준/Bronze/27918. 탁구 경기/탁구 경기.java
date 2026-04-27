import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int D = 0;
		int P = 0;
		int flag = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (str.contentEquals("D")) D += 1;
			else if (str.contentEquals("P")) P += 1;
			
			if (D == P + 2) {
				System.out.println(D + ":" + P);
				flag = 1;
				break;
			}
			else if (P == D + 2) {
				System.out.println(D + ":" + P);
				flag = 1;
				break;
			}
		}
		if (flag == 0) System.out.println(D + ":" + P);
		sc.close();
	}
}