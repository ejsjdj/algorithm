import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
			int sum = 0;
			int cnt = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'O') {
					cnt += 1;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
		System.out.println(sum);
		}
	}
}
