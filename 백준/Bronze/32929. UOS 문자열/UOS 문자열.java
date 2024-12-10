import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		
		int n = (int) num % 3;
		
		char[] arr = {'S', 'U', 'O'};
		
		System.out.println(arr[n]);
		
		sc.close();
		
	}
	
}