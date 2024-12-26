import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] arr = input.split("\\.");
        
        boolean isPossible = true;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty()) { 
                sb.append(".");
                continue;
            }
            
            int len = arr[i].length();
            
            while (len >= 4) {
                sb.append("AAAA");
                len -= 4;
            }
            
            if (len == 2) {
                sb.append("BB");
            } else if (len > 0) { 
                isPossible = false;
                break;
            }
            
            if (i < arr.length - 1) {
                sb.append(".");
            }
        }
        
        int trailingDots = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '.') trailingDots++;
            else break;
        }

        for (int i = 0; i < trailingDots; i++) {
            sb.append(".");
        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        
        sc.close();
    }
}