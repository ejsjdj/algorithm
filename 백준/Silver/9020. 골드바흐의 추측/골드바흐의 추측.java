import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < num / 2; j++) {
				if (isPrime(num / 2 - j) == true && isPrime(num/ 2 + j) == true) {
					System.out.print(num / 2 - j);
					System.out.print(" ");
					System.out.println(num / 2 + j);
					break;
				}
			}
		}

	}
	
    public static boolean isPrime(int num) {
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