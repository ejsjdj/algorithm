import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        char c = s.charAt(0);
        
        if (c == 'F') {
            System.out.println("Foundation");
        } else if (c == 'C') {
            System.out.println("Claves");
        } else if (c == 'V') {
            System.out.println("Veritas");
        } else {
            System.out.println("Exploration");
        }
    }
}
