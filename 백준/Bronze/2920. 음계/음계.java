import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		int[] nums = new int[8];
		
		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		int num = 0;
		boolean flag = true;
		if (nums[0] == 1) {
			num = 1;
			for (int i = 1; i < 8; i++) {
				if (nums[i] != num + i) {
					flag = false;
					break;
				}
			}
		} else if (nums[0] == 8) {
			num = 8;
			for (int i = 1; i < 8; i++) {
				if (nums[i] != num - i) {
					flag = false;
					break;
				}
			}
		}
		
		if (num == 1 && flag == true) System.out.println("ascending");
		else if (num == 8 && flag == true) System.out.println("descending");
		else System.out.println("mixed");
	}
}