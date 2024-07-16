import java.util.Arrays;

class FileSort {
    String name;
    String head;
    int num;

    public FileSort(String word) {
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                start = i;
                break;
            }
        }
        
        for (int i = start; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                end = i;
                break;
            }
        }
        
        if (end == 0) {
            end = word.length();
        }
        
        name = word;
        head = word.substring(0, start).toLowerCase();
        num = Integer.parseInt(word.substring(start, end));
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        FileSort[] arr = new FileSort[files.length];
        
        for (int i = 0; i < files.length; i++) {
        	arr[i] = new FileSort(files[i]);
        }
//        for (int i = 0; i < arr.length; i++) {
//        	System.out.printf("%s, %d\n", arr[i].head, arr[i].num);
//        	
//        }
        Arrays.sort(arr, (o1, o2) -> {
            int headCompare = o1.head.compareTo(o2.head);
            if (headCompare != 0) {
                return headCompare;
            } else {
                return o1.num - o2.num;
            }
        });
        
        for (int i = 0; i < arr.length; i++) {
        	answer[i] = arr[i].name;
        }
        return answer;
    }
}