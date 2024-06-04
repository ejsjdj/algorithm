class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] dif = new int[numlist.length];
        for (int i = 0; i < dif.length; i++) {
        	dif[i] = Math.abs(numlist[i] - n);
        }
        
        
        for (int i = 0; i < numlist.length; i++) {
        	for (int j = i + 1; j < numlist.length; j++) {
        		if (dif[i] > dif[j]) {
        			int tmp = dif[i];
        			dif[i] = dif[j];
        			dif[j] = tmp;
        			tmp = numlist[i];
        			numlist[i] = numlist[j];
        			numlist[j] = tmp;
        		}
        		else if (dif[i] == dif[j]) {
        			if (numlist[i] < numlist[j]) {
        				int tmp = numlist[i];
            			numlist[i] = numlist[j];
            			numlist[j] = tmp;
        			}
        		}
        	}
        }
        for (int i = 0; i < numlist.length; i++) {
        	for (int j = i + 1; j < numlist.length; j++) {
        		if (dif[i] > dif[j]) {
        			int tmp = dif[i];
        			dif[i] = dif[j];
        			dif[j] = tmp;
        			tmp = numlist[i];
        			numlist[i] = numlist[j];
        			numlist[j] = tmp;
        		}
        		else if (dif[i] == dif[j]) {
        			if (numlist[i] < numlist[j]) {
        				int tmp = numlist[i];
            			numlist[i] = numlist[j];
            			numlist[j] = tmp;
        			}
        		}
        	}
        }
        
        
        return numlist;
    }
}