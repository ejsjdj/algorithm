import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Result {
	String id;
	String Status;
	
	public Result (String id, String Status) {
		this.id = id;
		this.Status = Status;
	}
}

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> hm = new HashMap<>();
        List<Result> list = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
        	String[] now = record[i].split(" ");
        	if (now.length == 3) {
        		hm.put(now[1], now[2]);
        	}
        	
        	if (now[0].equals("Enter")) {
        		list.add(new Result(now[1], "님이 들어왔습니다."));
        	} else if (now[0].equals("Leave")) {
        		list.add(new Result(now[1], "님이 나갔습니다."));
        	}
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = hm.get(list.get(i).id) + list.get(i).Status;
        }
        
        
        return answer;
    }
}