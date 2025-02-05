import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 두 수열의 크기
        
        // 첫 번째 수열 A 입력
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 두 번째 수열 B 입력 및 인덱스 매핑 생성
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            indexMap.put(B[i], i);
        }
        
        // A를 B의 인덱스 기반으로 변환
        int[] transformedA = new int[N];
        for (int i = 0; i < N; i++) {
            transformedA[i] = indexMap.get(A[i]);
        }
        
        // 변환된 배열에서 LIS 계산
        System.out.println(findLIS(transformedA));
    }
    
    private static int findLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            // 현재 숫자가 LIS에 들어갈 위치를 이진 탐색으로 찾기
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1); // 삽입 위치 계산
            if (pos == lis.size()) {
                lis.add(num); // LIS 끝에 추가
            } else {
                lis.set(pos, num); // 기존 값을 대체
            }
        }
        
        return lis.size();
    }
}