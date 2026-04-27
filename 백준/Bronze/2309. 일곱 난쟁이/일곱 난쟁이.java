import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 난쟁이들의 키를 넣어줄 배열
		int[] arr = new int[9];

		// 난쟁이들의 키의 합을 넣어줄 변수
		int sum = 0;

		// 난쟁이들의 키와 키의 합을 반복해서 입력
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		// 배열을 정렬
		Arrays.sort(arr);

		// 범인을 찾기위한 변수 두개 선언
		int x = 0;
		int y = 0;

		// 두명의 키를 뺏을때 100이되면 그 두명이 범인
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					x = i;
					y = j;
					i = 9;
					break;
				}
			}
		}

		// 범인만 빼고 출력
		for (int i = 0; i < 9; i++) {
			if (i != x && i != y) {
				System.out.println(arr[i]);
			}
		}

	}
}