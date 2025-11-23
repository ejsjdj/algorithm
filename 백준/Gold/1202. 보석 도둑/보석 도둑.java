import java.util.*;
import java.io.*;

class jewel implements Comparable<jewel> {
    int weight;
    int value;

    public jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(jewel o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewel[] jewels = new jewel[N];
        int[] bag = new int[K];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jewels);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;  
        int idx = 0;
        
        for (int i = 0; i < K; i++) {
            int size = bag[i];

            while(idx < N && size >= jewels[idx].weight) {
                pq.add(jewels[idx].value);
                idx++;
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}