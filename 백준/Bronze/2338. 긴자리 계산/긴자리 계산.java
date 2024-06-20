import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger sum = a.add(b);
		BigInteger sub = a.subtract(b);
		BigInteger multi = a.multiply(b);
		System.out.println(sum);
		System.out.println(sub);
		System.out.println(multi);
	}
}
