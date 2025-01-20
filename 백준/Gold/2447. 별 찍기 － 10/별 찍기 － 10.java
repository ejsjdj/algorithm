import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
    	int N = sc.nextInt();
        char[][] pattern = new char[N][N];

        // 패턴 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pattern[i][j] = ' ';
            }
        }

        // 재귀적으로 패턴 생성
        createPattern(pattern, 0, 0, N);

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 재귀적으로 패턴을 생성하는 함수
    public static void createPattern(char[][] pattern, int x, int y, int size) {
        if (size == 1) { // 가장 작은 단위의 패턴
            pattern[x][y] = '*';
            return;
        }

        int newSize = size / 3; // 다음 단계의 패턴 크기

        // 3x3 그리드에서 각 칸에 대해 처리
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // 가운데 칸은 공백으로 남김
                    continue;
                }
                // 나머지 칸은 재귀적으로 패턴 생성
                createPattern(pattern, x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}