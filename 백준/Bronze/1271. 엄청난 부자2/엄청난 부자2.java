import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		
		sc.close();
		
		BigInteger a = n.divide(m);
		BigInteger b = n.remainder(m);
		
		System.out.println(a);
		System.out.println(b);
	}
}