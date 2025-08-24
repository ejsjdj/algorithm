import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static List<Integer> list;
    static StringBuilder sb;
    
    static void recur(int K, int depth) {
        if (depth == M) {
            sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = K; i <= N; i++) {
                list.add(i);
                recur(i, depth + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        recur(1,0);
    }
}