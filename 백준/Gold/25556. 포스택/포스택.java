import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
        }
        
        for (int value : A) {
            boolean placed = false;
            for (int i = 0; i < 4; i++) {
                if (stacks[i].isEmpty() || stacks[i].peek() < value) {
                    stacks[i].push(value);
                    placed = true;
                    break;
                }
            }
            
            if (!placed) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }
}