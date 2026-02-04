import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			
			int cnt = 0;
			
			for (int i = num + 1; i <= 2 * num; i++) {
				if (isPrime3(i) == true) {
					cnt++;
					i++;
				} else {
					continue;
				}
			}
			System.out.println(cnt);
		}
	}
	
    public static boolean isPrime3(int num) {
//    	if (num == 1) {
//    		return false;
//    	}
        boolean result = true;
        int end = (int)Math.sqrt(num);
        for(int i = 2; i <= end; i++) {
            if( num%i == 0) {
                result = false;
                break; 
                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
            } else {
                result = true;
            }
        }        
        return result;        
    }
}