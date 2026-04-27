public class Main {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for (int i = 0; i < arr.length; i++) {
			if (d(i) <= 10000) {
				arr[d(i)] = true;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == false) {
				System.out.println(i);
			}
		}
	}

	public static int d (int number) {
		int selfNumber = number;
		
		while (number != 0) {
			selfNumber += number % 10;
			number = number / 10;
		}
		return selfNumber;
	}
}