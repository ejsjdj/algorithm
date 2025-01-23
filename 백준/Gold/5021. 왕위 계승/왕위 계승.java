import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person {
    String name;
    String father;
    String mother;
    double legitimacy;

    public Person(String name, String father, String mother) {
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.legitimacy = 0.0;
    }
}

public class Main {

    static List<Person> family;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        family = new ArrayList<>();
        String[] claimers = new String[M];

        // 왕 이름 입력 및 초기화
        String kingName = bf.readLine().trim();
        Person king = new Person(kingName, null, null);
        king.legitimacy = 1.0; // 왕의 정통성은 1
        family.add(king);

        // 가족 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            family.add(new Person(st.nextToken(), st.nextToken(), st.nextToken()));
        }

        // 클레임을 주장하는 사람들 입력
        for (int i = 0; i < M; i++) {
            claimers[i] = bf.readLine().trim();
        }

        // 결과 계산
        String result = "";
        double maxLegitimacy = -1;

        for (String name : claimers) {
            Person claimant = search(name);
            if (claimant != null) {
                double legitimacy = getLegitimacy(claimant);
                if (legitimacy > maxLegitimacy) {
                    maxLegitimacy = legitimacy;
                    result = name;
                }
            }
        }

        System.out.println(result);
    }

    static double getLegitimacy(Person person) {
        if (person == null) return 0.0; // null이면 0 반환
        if (person.legitimacy > 0) return person.legitimacy; // 이미 계산된 경우 반환

        // 부모의 정통성을 계산하고 현재 사람의 정통성에 추가
        double fatherLegitimacy = getLegitimacy(search(person.father)) / 2;
        double motherLegitimacy = getLegitimacy(search(person.mother)) / 2;

        person.legitimacy += fatherLegitimacy + motherLegitimacy;

        return person.legitimacy;
    }

    static Person search(String name) {
        for (Person p : family) {
            if (p.name.equals(name)) return p;
        }
        return null; // 이름이 없으면 null 반환
    }
}