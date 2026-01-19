import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] adj;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean[] inPath;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        adj = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                adj[i][j] = line.charAt(j);
            }
        }
        
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == 'Y' && adj[j][i] == 'N') {
                    graph.get(i).add(j);
                }
            }
        }
        
        visited = new boolean[N];
        inPath = new boolean[N];
        
        boolean hasCycle = false;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
        
        System.out.println(hasCycle ? "NO" : "YES");
    }
    
    static boolean dfs(int node) {
        visited[node] = true;
        inPath[node] = true;
        
        for (int next : graph.get(node)) {
            if (inPath[next]) {
                return true;
            }
            if (!visited[next]) {
                if (dfs(next)) {
                    return true;
                }
            }
        }
        
        inPath[node] = false; 
        return false;
    }
}
