import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Tree {
	
	int remain = 0;
	int given = 0;
	Tree parent;
	public Tree(Tree parent) {
		this.parent = parent;
	}
	
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    		
    		HashMap<String, Integer> hm = new HashMap<>();
    		
    		List<Tree> list = new ArrayList<>();
    		
    		hm.put("-", 0);
    		list.add(new Tree(null));
    		
    		for (int i = 0; i < enroll.length; i++) {
    			String now = enroll[i];
    			String parent = referral[i];
    			
    			hm.put(now, hm.size());
    			int parentIdx = hm.get(parent);
    			
    			Tree tree = new Tree(list.get(parentIdx));
    			
    			list.add(tree);
    		}
    		
    		for (int i = 0; i < seller.length; i++) {
    			String name = seller[i];
    			int sell = amount[i];
    			
    			int idx = hm.get(name);
    			Tree tree = list.get(idx);
    			
    			update(tree, sell * 100);
    		}
    		
    		// 결과저장
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
        		answer[i] = list.get(i + 1).remain;
        }
        return answer;
    }
    
    void update(Tree now, int given) {
    		if (now.parent == null) now.remain += given;
    		else {
    			int update = (int) (given * 0.1);
    			now.remain += given - update;
    			update(now.parent, update);
    		}
    }
}