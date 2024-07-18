import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<Character> skilltree = new ArrayList<>();
        
        for (int i = 0; i < skill.length(); i++) {skilltree.add(skill.charAt(i));}
        
        for (int i = 0; i < skill_trees.length; i++) {
        	int pointer = 0;
        	boolean flag = false;
        	for (int j = 0; j < skill_trees[i].length(); j++) {
        		if (skilltree.contains(skill_trees[i].charAt(j))) {
        			if (skilltree.get(pointer) == skill_trees[i].charAt(j)) pointer++;
        			else {
        				break;
        			}
        		}
        		if (j == skill_trees[i].length()-1) flag = true;
        	}
        	if (flag) answer++;
        }
        return answer;
    }
}