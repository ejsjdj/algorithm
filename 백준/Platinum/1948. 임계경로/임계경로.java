import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<dNode>> A = new ArrayList<>();
		ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			A.add(new ArrayList<>());
			reverseA.add(new ArrayList<>());
		}
		int[] indegree = new int[N + 1];	// 진입 차수 배열
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			A.get(S).add(new dNode (E, V));
			reverseA.get(E).add(new dNode(S, V));
			indegree[E]++;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startDosi = Integer.parseInt(st.nextToken());
		int endDosi = Integer.parseInt(st.nextToken());
		// 위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startDosi);
		int[] result = new int[N + 1];
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (dNode next : A.get(now)) {
				indegree[next.targetNode]--;
				result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
				if (indegree[next.targetNode] == 0) {
					queue.offer(next.targetNode);
				}
			}
		}
		// 위상 정렬 reverse
		int resultCount = 0;
		boolean visited[] = new boolean[N + 1];
		queue = new LinkedList<>();
		queue.offer(endDosi);
		visited[endDosi] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (dNode next : reverseA.get(now)) {
				// 1분도 쉬지 않는 도로 체크하기
				if (result[next.targetNode] + next.value == result[now]) {
					resultCount++;
					// 중복 카운트 방지를 위해 이미 방문한 적이 있는 노드 제외하기
					if (visited[next.targetNode] == false) {
						visited[next.targetNode] = true;
						queue.offer(next.targetNode);
					}
				}
			}
		}
		System.out.println(result[endDosi]);
		System.out.println(resultCount);
	}
}
class dNode {
	int targetNode;
	int value;
	dNode (int targetNode, int value) {
		this.targetNode = targetNode;
		this.value = value;
	}
}