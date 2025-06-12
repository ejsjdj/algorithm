import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int T = Integer.parseInt(st.nextToken());
    	
    	while (T-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());	// 건물의 개수
    		int K = Integer.parseInt(st.nextToken());	// 건설 규칙의 개수
    		
    		int[] buildTime = new int[N + 1];	// 건설 시간을 저장할 배열
    		int[] buildTime2 = new int[N + 1];	// 건설 시간을 저장할 배열
    		int[] buildRequisition = new int[N + 1];	// 건설 필요 조건의 수를 저장할 배열
    		List<List<Integer>> buildOrder = new ArrayList<>();	// 해당 건물이 건설됬을때 건설가능해지는 건물을 저장하는 리스트
    		for (int i = 0; i < N + 1; i++) {
    			buildOrder.add(new ArrayList<>());
    		}
    		st = new StringTokenizer(br.readLine());
    		for (int i = 1; i < N + 1; i++) {
    			int time = Integer.parseInt(st.nextToken());	// 각 건물의 건설 시간을 저장
    			buildTime[i] = time;
    			buildTime2[i] = time;
    		}
    		
    		for (int i = 0; i < K; i++) {	// 건설 규칙을 입력
    			st = new StringTokenizer(br.readLine());
    			int require = Integer.parseInt(st.nextToken());
    			int complement = Integer.parseInt(st.nextToken());
    			buildRequisition[complement]++;
    			buildOrder.get(require).add(complement);
    		}
    		
    		Queue<Integer> queue = new LinkedList<>();
    		for (int i = 1; i < N + 1; i++) {
    			if (buildRequisition[i] == 0) queue.add(i);
    		}
    		
    		while (!queue.isEmpty()) {
    			int now = queue.poll();
    			for (int i : buildOrder.get(now)) {
    				if (buildTime[i] + buildTime2[now] > buildTime2[i]) buildTime2[i] = buildTime[i] + buildTime2[now];
    				buildRequisition[i]--;
    				if (buildRequisition[i] == 0) queue.add(i);
    			}
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		System.out.println(buildTime2[Integer.parseInt(st.nextToken())]);
    	}
    }
}