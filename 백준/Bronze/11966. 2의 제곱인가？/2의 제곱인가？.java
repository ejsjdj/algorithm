import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		boolean flag = true;
		
		while (N > 1) {	
			if(N % 2 != 0) {
				flag = false;
				break;
			}
			N /= 2;			
		}
		
		if(flag) {
			System.out.println(1);			
		} else {
			System.out.println(0);
		}
		sc.close();
	}
}