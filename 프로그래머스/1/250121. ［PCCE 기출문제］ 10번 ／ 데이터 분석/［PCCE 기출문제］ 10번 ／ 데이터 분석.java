import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
//        ["코드 번호(code)", 
//        "제조일(date)", 
//        "최대 수량(maximum)", 
//        "현재 수량(remain)"]
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
		if (ext.equals("code")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][0] < val_ext) {
					list.add(new ArrayList<Integer>(Arrays.asList(data[i][0], data[i][1], data[i][2], data[i][3])));
				}
			}
		} else if (ext.equals("date")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][1] < val_ext) {
					list.add(new ArrayList<Integer>(Arrays.asList(data[i][0], data[i][1], data[i][2], data[i][3])));
				}
			}
		} else if (ext.equals("maximum")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][2] < val_ext) {
					list.add(new ArrayList<Integer>(Arrays.asList(data[i][0], data[i][1], data[i][2], data[i][3])));
				}
			}
		} else if (ext.equals("remain")) {
			for (int i = 0; i < data.length; i++) {
				if (data[i][3] < val_ext) {
					list.add(new ArrayList<Integer>(Arrays.asList(data[i][0], data[i][1], data[i][2], data[i][3])));
				}
			}
		}
		
		if (sort_by.equals("code")) {
			Collections.sort(list, (o1, o2) -> {
				return o1.get(0) - o2.get(0);
			});
		} else if (sort_by.equals("date")) {
			Collections.sort(list, (o1, o2) -> {
				return o1.get(1) - o2.get(1);
			});
		} else if (sort_by.equals("maximum")) {
			Collections.sort(list, (o1, o2) -> {
				return o1.get(2) - o2.get(2);
			});
		} else if (sort_by.equals("remain")) {
			Collections.sort(list, (o1, o2) -> {
				return o1.get(3) - o2.get(3);
			});
		}
		
		int[][] answer = new int[list.size()][4];
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				answer[i][j] = list.get(i).get(j);
			}
		}
        
//        정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext, 
//        뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 
//        정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
//
//        data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, 
//        sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요. 
//        단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.


        
        return answer;
    }
}