import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String[] str_arr = str.split("-");
		
		String[] arr = str_arr[0].split("\\+");
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		for (int i = 1; i < str_arr.length; i++) {
			arr = str_arr[i].split("\\+");
			for (int j = 0; j < arr.length; j++) {
				sum -= Integer.parseInt(arr[j]);
			}
		}
		System.out.println(sum);
		sc.close();
	}
}