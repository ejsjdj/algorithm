import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Genre {
	String genre;
	int total;
	int first = -1;
	int firstIdx = -1; 
	int second = -1;
	int secondIdx = -1;
	int idx;

	public Genre(String genre, int total, int idx) {
		this.genre = genre;
		this.total = total;
		this.idx = idx;
		this.firstIdx = idx;
	}
}

class Solution {

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Genre> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				map.get(genres[i]).total += plays[i];
			} else {
				map.put(genres[i], new Genre(genres[i], plays[i], i));
			}
			if (map.get(genres[i]).first < plays[i]) {
				int tmp = map.get(genres[i]).first;
				int idxTmp = map.get(genres[i]).firstIdx;
				map.get(genres[i]).first = plays[i];
				map.get(genres[i]).firstIdx = i;
				map.get(genres[i]).second = tmp;
				map.get(genres[i]).secondIdx = idxTmp;
			} else if (map.get(genres[i]).second < plays[i]) {
				map.get(genres[i]).second = plays[i];
				map.get(genres[i]).secondIdx = i;
			}
		}
		
		Genre[] arr = new Genre[map.size()];
		Set<String> set = map.keySet();
		int k = 0;
		
		for (String str : set) {
			arr[k] = map.get(str);
			k++;
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			int n = -1;
			if (o2.total - o1.total > 0) n = 1;
			else if (o1.total == o2.total) {
				if (o1.idx - o2.idx > 0) n = -1;
			}
			return n;
		});
		
		List<Integer> answer2 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].first >= 0) answer2.add(arr[i].firstIdx);
			if (arr[i].second >= 0) answer2.add(arr[i].secondIdx);
		}
		
		int[] answer = new int[answer2.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answer2.get(i);
		}

		return answer;
	}
}