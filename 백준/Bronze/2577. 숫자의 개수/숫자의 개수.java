import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //스캐너 사용
		
		int value = sc.nextInt() * sc.nextInt() * sc.nextInt(); //value에 입력될 세 값의 곱을 저장
		
		String str = Integer.toString(value); //str에 value를 문자열로 변경하여 저장
		
		for(int i = 0; i < 10; i++) {
			int count = 0; //카운터 선언
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) - '0' == i) {
					count += 1;
				}
			}
			System.out.println(count); //각 수를 출력
		}
	}
}
