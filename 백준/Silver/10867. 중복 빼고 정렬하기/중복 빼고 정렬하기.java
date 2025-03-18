import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        
        // 중복을 제거한 후 정렬된 리스트에 추가
        for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));
        
        // set을 list로 변환하고 정렬
        list.addAll(set);
        Collections.sort(list); // 리스트 정렬
        
        for (int i : list) {
            System.out.print(i + " ");
        }
        
    }
}