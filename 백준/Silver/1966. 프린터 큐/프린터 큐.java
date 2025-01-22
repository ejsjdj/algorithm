import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 초기 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>(); // 문서를 저장할 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위를 저장하는 우선순위 큐 (내림차순)

            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken()); // 문서의 우선순위
                queue.add(new int[]{j, priority}); // 큐에 [문서 인덱스, 우선순위] 추가
                pq.add(priority); // 우선순위 큐에 우선순위 추가
            }

            int cnt = 0; // 출력된 문서의 개수를 카운트

            while (!queue.isEmpty()) { // 큐가 비어있지 않을 때까지 반복
                int[] current = queue.poll(); // 현재 문서를 큐에서 꺼냄

                // 현재 문서가 가장 높은 우선순위를 가진 경우
                if (current[1] == pq.peek()) {
                    pq.poll(); // 우선순위 큐에서 해당 우선순위를 제거
                    cnt++; // 출력된 문서 개수 증가

                    if (current[0] == M) { // 현재 문서가 우리가 찾는 문서(M)라면
                        System.out.println(cnt); // 출력된 순서를 출력
                        break; // 반복 종료
                    }
                } else {
                    // 현재 문서가 가장 높은 우선순위가 아니라면 다시 큐의 뒤로 이동
                    queue.add(current);
                }
            }
        }
    }
}