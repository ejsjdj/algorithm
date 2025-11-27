import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();

            if (input.equals("end")) {
                break;
            }

            switch (input) {
                case "animal":
                    System.out.println("Panthera tigris");
                    break;
                case "tree":
                    System.out.println("Pinus densiflora");
                    break;
                case "flower":
                    System.out.println("Forsythia koreana");
                    break;
            }
        }
        
        sc.close();
    }
}
