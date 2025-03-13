import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        long N = Long.parseLong(input[0]);
        long M = Long.parseLong(input[1]);
        
        if (N == M) System.out.println(1);
        else System.out.println(0);
        
        sc.close();
    }
}