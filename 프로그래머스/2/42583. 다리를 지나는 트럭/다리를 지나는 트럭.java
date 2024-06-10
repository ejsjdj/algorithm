import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Truck {
	int weight = 0;
	int x = 0;
	Truck (int weight) {
		this.weight = weight;
	}
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        
        Deque<Truck> trucks = new LinkedList<>();
        List<Truck> onBridge = new ArrayList<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
        	trucks.addFirst(new Truck(truck_weights[i]));
        }
        
        while (!trucks.isEmpty() || !onBridge.isEmpty()) {
        	for (int i = 0; i < onBridge.size(); i++) {
        		onBridge.get(i).x += 1;
        	}
        	if (!onBridge.isEmpty() && onBridge.get(0).x >= bridge_length) {
        		sum -= onBridge.remove(0).weight;
        	}
        	if (!trucks.isEmpty() && weight >= sum + trucks.getFirst().weight) {
        		onBridge.add(trucks.pollFirst());
        		sum += onBridge.get(onBridge.size()-1).weight;
        	} 
        	
        	answer++;
        }
        return answer;
    }
}