import java.util.Stack;

class Stock {
	public Stock(int price, int idx) {
		this.price = price;
		this.idx = idx;
	}
	int price;
	int idx;
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stock stock;
        
        Stack<Stock> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
        	if (stack.isEmpty() || stack.peek().price <= prices[i]) {
        		stack.push(new Stock(prices[i], i));
        	} else if (stack.peek().price > prices[i]) {
        		stock = stack.pop();
        		answer[stock.idx] = i - stock.idx;
        		i--;
        	}
        }
        
        while (! stack.isEmpty()) {
        	stock = stack.pop();
    		answer[stock.idx] = prices.length - stock.idx - 1;
        }
        
        return answer;
    }
}