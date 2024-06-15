import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
    	
    	str1 = str1.toLowerCase();
    	str2 = str2.toLowerCase();
        
        List<String> multiSet1 = getMultiSet(str1);
        List<String> multiSet2 = getMultiSet(str2);
        
        List<String> intersection = getIntersection(multiSet1, multiSet2);
        List<String> union = getUnion(multiSet1, multiSet2, intersection);
        
        if (union.size() == 0) return 65536;
        double answer = (double)intersection.size() / union.size() * 65536;
        
        return (int) answer;
    }
    
    List<String> getMultiSet(String str) {
    	List<String> result = new ArrayList<>();
    	for (int i = 0; i < str.length()-1; i++) {
    		if (Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(i+1))) {
    			result.add("" + str.charAt(i) + str.charAt(i + 1));
    		}
    	}
    	return result;
    }
    
    List<String> getUnion(List<String> multiSet1, List<String> multiSet2, List<String> intersection) {
    	List<String> result = new ArrayList<>();
    	result.addAll(multiSet1);
    	result.addAll(multiSet2);
    	
    	for (int i = 0; i < intersection.size(); i++) {
    		result.remove(intersection.get(i));
    	}
    	
    	return result;
    }
    
    List<String> getIntersection(List<String> multiSet1, List<String> multiSet2) {
    	
    	List<String> result = new ArrayList<>();
    	List<String> newMultiSet1 = new ArrayList<>();
    	
    	newMultiSet1.addAll(multiSet1);
    	
    	for (int i = 0; i < multiSet2.size(); i++) {
    		if (newMultiSet1.contains(multiSet2.get(i))) {
    			result.add(multiSet2.get(i));
    			newMultiSet1.remove(multiSet2.get(i));
    		}
    	}
    	
    	return result;
    }
}