import java.util.Arrays;

class Solution {
	public String[] solution(String[] str_list) {
		boolean flag = false;
		int start = 0;
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].equals("u") || str_list[i].equals("d")) {
				continue;
			} else if (str_list[i].equals("r")) {
				String[] answer = Arrays.copyOfRange(str_list, i + 1, str_list.length);
				return answer;
			} else if (str_list[i].equals("l")) {
				String[] answer = Arrays.copyOfRange(str_list, start, i);
				return answer;
			}
		}
		String[] answer = {};
		return answer;
	}
}