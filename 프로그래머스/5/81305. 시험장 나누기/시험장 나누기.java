class Node {
	int num;
	int left;
	int right;
	
	public Node(int num, int left, int right) {
		super();
		this.num = num;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	
	int cnt;
	int mid;
	Node[] nodes;
	
    public int solution(int k, int[] num, int[][] links) {
        
    	int answer = 0;
        int len = num.length;
        nodes = new Node[len];
        boolean[] check = new boolean[len];
        int min = 0;
        int max = 0;
        
        for (int i = 0; i < nodes.length; i++) {
        		int value = num[i];
        		int left = links[i][0];
        		int right = links[i][1];
        		
        		if (left != -1) check[left] = true;
        		if (right != -1) check[right] = true;
        		
        		min = Math.max(value, min);
        		max = max + value;
        		
        		nodes[i] = new Node(value, left, right);
        }
        
        int root = 0;
        for (int i = 0; i < check.length; i++) {
        		if (!check[i]) {
        			root = i;
        			break;
        		}
        }
        
        int left = min;
        int right = max;
        
        while (left <= right) {
        		mid = (left + right) / 2;
        		
        		cnt = 1;

        		dfs(root);
        		
        		if (cnt <= k) {
        			answer = mid;
        			right = mid - 1;
        		}
        		
        		else {
        			left = mid + 1;
        		}
        }
        
        return answer;

        
    }
    
    public int dfs(int i) {
	    	if (i == -1) return 0;
	    	
	    	Node node = nodes[i];
	    	
	    	int num = node.num;
	    	int left = node.left;
	    	int right = node.right;
	    	
	    	left = dfs(left);
	    	right = dfs(right);
	    	
	    	if (num + left + right <= mid) {
	    		return num + left + right;
	    		
	    	} else {
	    		if (num + Math.min(left, right) <= mid) {
	    			cnt = cnt + 1;
	    			return num + Math.min(left, right);
	    			
	    		} else {
	    			cnt = cnt + 2;

	    			return num;
	    		}
	    	}
    }
}