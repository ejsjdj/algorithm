import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextLong()) {
            long n = sc.nextLong();
            System.out.println(n * 2);
        }
        
        sc.close();
    }
}
