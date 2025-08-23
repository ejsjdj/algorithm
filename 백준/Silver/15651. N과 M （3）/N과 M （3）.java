import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    static int N;
    static int M;
    static StringBuilder sb;
    static List<Integer> list;

    static void recur(int depth) {
        if (depth == M) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        else {
            for (int i = 1; i <= N; i++) {
                list.add(i);
                recur(depth + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        list = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        recur(0);
        System.out.println(sb);
    }
}