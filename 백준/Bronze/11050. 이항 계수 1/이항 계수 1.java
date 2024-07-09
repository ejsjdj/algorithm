import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int i = 0;
		int answer = 1;
		while (i != M) {
			answer *= (N - i);
			i++;
		}
		i = 0;
		while (i != M) {
			answer /= (M - i);
			i++;
		}
		System.out.println(answer);
	}
}