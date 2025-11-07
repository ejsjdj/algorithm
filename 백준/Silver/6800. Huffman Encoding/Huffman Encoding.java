import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        
        // 이진 코드를 키로, 문자를 값으로 저장
        Map<String, Character> codeMap = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            char character = input[0].charAt(0);
            String code = input[1];
            codeMap.put(code, character);
        }
        
        String binarySequence = br.readLine();
        
        // 디코딩
        StringBuilder result = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        
        for (int i = 0; i < binarySequence.length(); i++) {
            currentCode.append(binarySequence.charAt(i));
            
            // 현재까지 읽은 코드가 맵에 있는지 확인
            if (codeMap.containsKey(currentCode.toString())) {
                result.append(codeMap.get(currentCode.toString()));
                currentCode = new StringBuilder(); // 초기화
            }
        }
        
        System.out.println(result.toString());
    }
}