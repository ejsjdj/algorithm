import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int cnt = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < cnt; i++) {            
            st = new StringTokenizer(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Long> sejun = new PriorityQueue<>();
            PriorityQueue<Long> sebi = new PriorityQueue<>();
            
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < S; j++) sejun.add(Long.parseLong(st.nextToken()));
            
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < B; j++) sebi.add(Long.parseLong(st.nextToken()));
            
            while (true) {
                if (sejun.peek() < sebi.peek()) {
                    sejun.poll();
                    if (sejun.isEmpty()) {
                        System.out.println("B");
                        break;
                    }
                } else {
                    sebi.poll();
                    if (sebi.isEmpty()) {
                        System.out.println("S");
                        break;
                    }
                }
            }
        }
    }
}