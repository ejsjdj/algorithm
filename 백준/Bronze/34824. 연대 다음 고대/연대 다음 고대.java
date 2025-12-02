import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int yonseiRank = 0;
        int koreaRank = 0;
        
        for (int i = 1; i <= n; i++) {
            String university = sc.next();
            
            if (university.equals("yonsei")) {
                yonseiRank = i;
            } else if (university.equals("korea")) {
                koreaRank = i;
            }
        }
        
        if (yonseiRank < koreaRank) {
            System.out.println("Yonsei Won!");
        } else {
            System.out.println("Yonsei Lost...");
        }
        
        sc.close();
    }
}
