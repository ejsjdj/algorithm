import java.util.PriorityQueue;

class Tree implements Comparable<Tree> {
	
	int index;
	int x;
	int y;
	Tree left;
	Tree right;
	
	public Tree(int index, int x, int y) {
		super();
		this.index = index;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Tree o) {
		if (this.y != o.y) {
			return o.y - this.y;
		} else if (this.x != o.y) {
			return this.x - o.y;
		} else {
			return this.index - o.index;
		}
	}
	
}

class Solution {
	
	Tree root;
	int[][] answer;
	int first = 0;
	int second = 0;
	
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i++) {
        		int index = i + 1;
        		int x = nodeinfo[i][0];
        		int y = nodeinfo[i][1];
        		
        		pq.add(new Tree(index, x, y));
        }
        
        root = pq.poll();
        
        while (!pq.isEmpty()) {
        		Tree now = pq.poll();
        		int index = now.index;
        		int x = now.x;
        		int y = now.y;
        		find(root, index, x, y);
        }
        
        preOrder(root);
        postOrder(root);
        
        return answer;
    }
    
    void find(Tree parent, int index, int x, int y) {
    		int parent_x = parent.x;
    		int parent_y = parent.y;
    		
    		if (parent_x > x) {
    			if (parent.left == null) parent.left = new Tree(index, x, y);
    			else find(parent.left, index, x, y);
    		} else {
    			if (parent.right == null) parent.right = new Tree(index, x, y);
    			else find(parent.right, index, x, y);
    		}
    }
    
    void preOrder(Tree tree) {
    		answer[0][first++] = tree.index;
    		if (tree.left != null) preOrder(tree.left);
    		if (tree.right != null) preOrder(tree.right);
    }
    
    void postOrder(Tree tree) {
    		if (tree.left != null) postOrder(tree.left);
    		if (tree.right != null) postOrder(tree.right);
    		answer[1][second++] = tree.index;
    }
}