import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Tree {
    String name;
    int cnt;
    public Tree(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> hm = new HashMap<>();
        double sum = 0;
        
        while (true) {
            String tree = bf.readLine();
            if (tree == null || tree.isEmpty()) break;
            hm.put(tree, hm.getOrDefault(tree, 0) + 1);
            sum++;
        }
        
        List<Tree> list = new ArrayList<>();
        Set<String> set = hm.keySet();
        for (String str : set) {
            list.add(new Tree(str, hm.get(str)));
        }
        
        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));
        
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s %.4f\n", list.get(i).name, (list.get(i).cnt / sum) * 100);
        }
    }
}