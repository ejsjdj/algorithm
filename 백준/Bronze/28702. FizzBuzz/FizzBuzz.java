import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n1 = sc.nextLine();
		String n2 = sc.nextLine();
		String n3 = sc.nextLine();
		
		String a = "Fizz";
		String b = "Buzz";
		String c = "FizzBuzz";
		int N = 0;
		if (!n3.equals(a) && !n3.equals(b) && !n3.equals(c)) {
			N = Integer.parseInt(n3)+1;
		}
		else if (!n2.equals(a) && !n2.equals(b) && !n2.equals(c)) {
			N = Integer.parseInt(n2)+2;
		} 
		else if (!n1.equals(a) && !n1.equals(b) && !n1.equals(c)) {
			N = Integer.parseInt(n1)+3;
		} 
		if (N % 3 == 0 && N % 5 == 0) System.out.println(c);
		else if (N % 3 == 0) System.out.println(a);
		else if (N % 5 == 0) System.out.println(b);
		else System.out.println(N);
	}
}