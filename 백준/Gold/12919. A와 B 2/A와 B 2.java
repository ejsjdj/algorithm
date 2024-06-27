import java.util.Scanner;
public class Main {
    static boolean change(String S, String T) {
        if (S.equals(T)) return true;
        
        if (T.length() < S.length()) return false;
        
        if (T.endsWith("A")) {
            if (change(S, T.substring(0, T.length() - 1))) return true;
        }
        if (T.startsWith("B")) {
            String newStr = new StringBuilder(T.substring(1)).reverse().toString();
            if (change(S, newStr)) return true;
        }
        

        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();
        sc.close();
        
        if (change(S, T)) {System.out.println(1);}
        else {System.out.println(0);}
    }
}