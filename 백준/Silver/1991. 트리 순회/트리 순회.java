import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	String name;
	Node left;
	Node right;
	public Node(String name) {
		this.name = name;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Node> tree = new ArrayList<>();
		// tree 에 N 의 개수만큼 노드를 생성
		for (int i = 0; i < N; i++) {
            tree.add(new Node(String.valueOf((char)('A' + i))));
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			if (!left.equals(".")) tree.get(root.charAt(0) - 'A').left = tree.get(left.charAt(0) - 'A');
			if (!right.equals(".")) tree.get(root.charAt(0) - 'A').right = tree.get(right.charAt(0) - 'A');
		}
		
		System.out.println(preOrder(tree.get(0)));
		System.out.println(inOrder(tree.get(0)));
		System.out.println(postOrder(tree.get(0)));
	}
	
	static String preOrder(Node now) {	// 전위 순회
		if (now == null) return "";
		return now.name + preOrder(now.left) + preOrder(now.right);
	}
	static String inOrder(Node now) {	// 중위 순회
		if (now == null) return "";
		return inOrder(now.left) + now.name + inOrder(now.right);
	}
	static String postOrder(Node now) {	// 후위 순회
		if (now == null) return "";
		return postOrder(now.left) + postOrder(now.right) + now.name;
	}
}