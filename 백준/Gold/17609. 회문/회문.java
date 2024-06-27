import java.util.Scanner;

public class Main {
    static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static int checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                // 범위를 벗어나지 않는지 확인한 후 회문 검사
                if ((left + 1 < str.length() && isPalindrome(str, left + 1, right)) || 
                    (right - 1 >= 0 && isPalindrome(str, left, right - 1))) {
                    return 1; 
                } else {
                    return 2; 
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            System.out.println(checkPalindrome(str));
        }
        
        sc.close();
    }
}