import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		int[] cards = new int[N];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = sc.nextInt();
		}
		
		System.out.println(function(cards, M));
	}
	
	public static int function(int[] arr, int num) {
		int maxNum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == num) {
						return arr[i] + arr[j] + arr[k];
					} else if (arr[i] + arr[j] + arr[k] < num && arr[i] + arr[j] + arr[k] > maxNum) {
						maxNum = arr[i] + arr[j] + arr[k];
					}
				}
			}
		}
		return maxNum;
	}
}