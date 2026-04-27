import java.util.Scanner;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sb.append((int) Math.pow((double) 2, (double) n) - 1).append('\n');
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
		sc.close();
	}
	public static void hanoi(int n, int start, int mid, int end) {
	
		if (n == 1) {
			sb.append(start + " " + end).append('\n');
		} else {
			hanoi (n - 1, start, end, mid);
			sb.append(start + " " + end).append('\n');
			hanoi (n - 1, mid, start, end);
		}
	}
}