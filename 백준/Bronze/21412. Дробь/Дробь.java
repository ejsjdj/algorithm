import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 1; i <= N / 2; i++) {
			if (gcd(N - i, i) == 1)  {
				a = i;
				b = N - i;
			}
		}
		
		System.out.println(a + " " + b);
		
		sc.close();
		
	}
	
	static int gcd(int a, int b) {
        while (b != 0) { 
            int r = a % b; 
            a = b;         
            b = r;         
        }
        return a; 
    }
}