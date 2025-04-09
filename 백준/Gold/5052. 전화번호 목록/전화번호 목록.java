import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TrieNode {
    TrieNode[] children = new TrieNode[10];
    boolean isEndOfNumber = false;
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public boolean insert(String number) {
        TrieNode node = root;
        boolean isPrefix = false;
        for (char c : number.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            } else {
                // 현재 노드가 이미 끝나는 전화번호이면(이미 접두어 존재)
                if (node.children[index].isEndOfNumber) {
                    isPrefix = true;
                }
            }
            node = node.children[index];
        }
        node.isEndOfNumber = true;
        
        for (TrieNode child : node.children) {
            // 마지막 노드가 자식을 갖는다면 (현재의 전화번호가 다른 전화번호의 접두어)
            if (child != null) {
                isPrefix = true;
                break;
            }
        }
        return isPrefix;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> phoneNumbers = new ArrayList<>();
            Trie trie = new Trie();
            boolean isConsistent = true;

            for (int i = 0; i < n; i++) {
                phoneNumbers.add(sc.next());
            }

            for (String number : phoneNumbers) {
                if (trie.insert(number)) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}