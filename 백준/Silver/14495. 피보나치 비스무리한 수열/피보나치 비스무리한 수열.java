import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        
        if (N <= 3) {
            System.out.println(1);
        } else {
            long a = 1, b = 1, c = 1;
            long tmp = 0;
            for (int i = 4; i <= N; i++) { 
                tmp = a + c; 
                a = b;
                b = c;
                c = tmp;
            }
            System.out.println(c);
        }
        
        sc.close();
    }
}
