import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (c.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        if (num == 1) {
                            int key = map.lastKey();
                            if (map.get(key) == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, map.get(key) - 1);
                            }
                        } else {
                            int key = map.firstKey();
                            if (map.get(key) == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, map.get(key) - 1);
                            }
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}