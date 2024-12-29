import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
	
	String name;
	Edge last;
	Edge next;
	
	boolean[] arr;
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        while (true) {
        	cnt++;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;
            
            Edge[] edges = new Edge[N];

            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(bf.readLine());
            	edges[i] = new Edge();
            	edges[i].name = st.nextToken();
            	edges[i].arr = new boolean[N-1];
            	
            	for (int j = 0; j < N - 1; j++) {
            		String resp = st.nextToken();
            		if (resp.equals("P")) edges[i].arr[j] = false;
            		else edges[i].arr[j] = true;
            	}
            	
            }
            
            edges[0].last = edges[edges.length - 1];
            edges[0].next = edges[1];
            edges[edges.length - 1].last = edges[edges.length - 2];
            edges[edges.length - 1].next = edges[0];
            
            for (int i = 1; i < edges.length - 1; i++) {
            	edges[i].next = edges[i + 1];
            	edges[i].last = edges[i - 1];
            }
            
            sb.append("Group ");
            sb.append(cnt);
            sb.append("\n");
            boolean flag = true;
            for (int i = 0; i < edges.length; i++) {
            	
            	for (int j = 0; j < edges[i].arr.length; j++) {
            		if (edges[i].arr[j]) {
            			Edge now = edges[i];
            			for (int k = 0; k < j + 1; k++) {
            				now = now.last;
            			}
            			sb.append(now.name);
            			sb.append(" was nasty about ");
            			sb.append(edges[i].name);
            			sb.append("\n");
            			flag = false;
            		}
            	}
            }
            if (flag) sb.append("Nobody was nasty\n");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}