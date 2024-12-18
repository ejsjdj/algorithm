import java.util.Scanner;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;*/

public class Main {

	public static void main(String[] args) {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * StringTokenizer st = new StringTokenizer(br.readLine());
		 * 
		 * System.out.println(Integer.parseInt(st.nextToken()) +
		 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		 * br.close();
		 */
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		System.out.printf("%.0f", a+b+c);
		
		sc.close();
	}
}
