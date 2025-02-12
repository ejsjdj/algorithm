import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    static int T,N,M,W;
    static List<Edge> graph;
    static long[] distance;

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for(int i=0;i<M+W;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(i<M){
                    graph.add(new Edge(s,e,v));
                    graph.add(new Edge(e,s,v));
                }
                else graph.add(new Edge(s,e,-v));
            }

            distance = new long[N+1];
            Arrays.fill(distance,Integer.MAX_VALUE);
            distance[1] = 0;

            for(int i=1;i<=N;i++){
                for(int j=0;j<graph.size();j++){
                    Edge edge = graph.get(j);

//                    if(distance[edge.s] != Integer.MAX_VALUE)
                        distance[edge.e] = Math.min(distance[edge.e], distance[edge.s]+ edge.v);
                }
            }

            boolean minusCycle = false;
            for(int i=0;i< graph.size();i++){
                Edge edge = graph.get(i);
//                if(distance[edge.s] != Integer.MAX_VALUE && distance[edge.e] > distance[edge.s]+ edge.v){
                if(distance[edge.e] > distance[edge.s]+ edge.v){
                    minusCycle = true;
                    break;
                }
            }

            if(minusCycle) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    static class Edge{
        int s;
        int e;
        int v;

        Edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}