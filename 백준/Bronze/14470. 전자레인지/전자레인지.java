import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // 고기가 얼어 있고 온도가 0미만일때 C초에 1씩 오른다.
        // 고기가 얼어있지 않고 온도가 정확히 0일때 해동하는데 D초가 걸린다.
        // 고기가 얼어있지 않을때 온도가 E초에 1식 오른다.
        
        Scanner sc = new Scanner(System.in);
        // 원래 고기의 온도
        int A = sc.nextInt();
        // 목표 온도
        int B = sc.nextInt();
        // 얼어있는 고기를 1도 올리는데 걸리는 시간
        int C = sc.nextInt();
        // 얼어있는 고기를 해동하는데 걸리는 시간 
        int D = sc.nextInt();
        // 얼어있지 않은 고기를 1도 올리는데 걸리는 시간
        int E = sc.nextInt();
        
        int result = 0;
        if (A < 0) {
            result += C * (-A);
            A = 0;
        }
        if (A == 0) result += D;
        if (A < B) {
            int time = B - A;
            result += time * E;
        }
        System.out.println(result);
    }
}