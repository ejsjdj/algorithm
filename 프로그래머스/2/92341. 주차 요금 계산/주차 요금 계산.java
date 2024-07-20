import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Info {
	int time;
	String carNum;
	String state = "IN";
	int total = 0;
	public Info(int time, String carNum) {
		this.time = time;
		this.carNum = carNum;
	}
	
	public void totalSet(int leave) {
		this.total += leave - time;
	}
	
	public int calc (int basicTime, int basicPay, int unitTime, int payByUnit) {
		if (state.equals("IN")) total += 23*60 + 59 - time;
		
		if (basicTime > total) return basicPay;
		
		else {
			int pay = basicPay + (total - basicTime) / unitTime * payByUnit;
			if ((total - basicTime)%unitTime > 0) pay += payByUnit;
			return pay;
		}
	}
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
    	int basicTime = fees[0];
    	int basicPay = fees[1];
    	int unitTime = fees[2];
    	int payByUnit = fees[3];
    	
    	List<Info> list = new ArrayList<>();
    	
    	for (int i = 0; i < records.length; i++) {
    		
    		String[] now = records[i].split(" ");
    		
    		int time = Integer.parseInt(now[0].split(":")[0]) * 60 + Integer.parseInt(now[0].split(":")[1]);
    		String carNum = now[1];
    		String state = now[2];
    		
    		if (state.equals("IN")) {
    			boolean isHad = false;
    			for (Info info : list) {
    				if (info.carNum.equals(carNum)) {
    					info.time = time;
    					info.state = "IN";
    					isHad = true;
    					break;
    				}
    			}
    			if (!isHad) list.add(new Info(time, carNum));
    		}
    		
    		else {
    			for (Info info : list) {
    				if (info.carNum.equals(carNum)) {
    					info.totalSet(time);
    					info.state = "OUT";
    					break;
    				}
    			}
    		}
    	}
    	
    	Collections.sort(list, (o1, o2) -> {
    		return o1.carNum.compareTo(o2.carNum);
    	});
    	
    	int[] answer = new int[list.size()];
    	
    	for (int i = 0; i < answer.length; i++) {
    		answer[i] = list.get(i).calc(basicTime, basicPay, unitTime, payByUnit);
    	}
    	
        return answer;
    }
}