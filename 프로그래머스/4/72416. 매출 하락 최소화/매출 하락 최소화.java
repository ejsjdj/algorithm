import java.util.ArrayList;
import java.util.List;

class Person {
	int idx;
	int sale;
	
	public Person(int idx, int sale) {
		super();
		this.idx = idx;
		this.sale = sale;
	}

	List<Integer> list = new ArrayList<>();
}

class Solution {
	
	int[][] DP; // 0은 자기를 안포함
				// 1은 자기를 포함
	
	Person[] persons;
    public int solution(int[] sales, int[][] links) {
        
        DP = new int[sales.length + 1][2];
        
        for (int i = 0; i < DP.length; i++) {
        		DP[i][0] = 0;
        		DP[i][1] = 0;
        }
        
        persons = new Person[sales.length + 1];
        for (int i = 0; i < sales.length; i++) {
        		int sale = sales[i];
        		persons[i + 1] = new Person(i + 1, sale);
        }
        
        for (int i = 0; i < links.length; i++) {
        		int a = links[i][0];
        		int b = links[i][1];
        		persons[a].list.add(b);
        }
        
        DFS(persons[1]);
        
        return Math.min(DP[1][0], DP[1][1]);
    }
    
    void DFS(Person person) {
    		
    		for (int i : person.list) {
    			Person child = persons[i];
    			DFS(child);
    		}
    		
    		int idx = person.idx;
    		int sale = person.sale;
    		
    		if (person.list.size() == 0) {
    			DP[idx][0] = 0;
    			DP[idx][1] = sale;
    			return;
    		}
    		
    		DP[idx][0] = 0;
    		DP[idx][1] = sale;
    		
    		int diff = Integer.MAX_VALUE;	// 가장 작은 DP[i][1] 을 저장한다?
    		boolean flag = false;
    		for (int i : person.list) {
    			DP[idx][1] += Math.min(DP[i][0], DP[i][1]);
    			
    			if (DP[i][0] > DP[i][1]) {
    				DP[idx][0] += DP[i][1];
    				flag = true;
    			}
    			else {
    				DP[idx][0] += DP[i][0];
    				diff = Math.min(diff, DP[i][1] - DP[i][0]);
    			}
    		}
    		if (!flag) {
    			DP[idx][0] += diff;
    		}
    }
}