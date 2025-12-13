import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Player implements Comparable<Player> {
    int score;
    String time;
    String team;

    public Player(String time, String team) {
        this.time = time;
        this.team = team;
    }

    @Override
    public int compareTo(Player o) {
        return this.time.compareTo(o.time);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Player[] players = new Player[8];

        for(int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(st.nextToken(), st.nextToken());
            players[i] = player;
        }

        Arrays.sort(players);

        players[0].score = 10;
        players[1].score = 8;
        players[2].score = 6;
        players[3].score = 5;
        players[4].score = 4;
        players[5].score = 3;
        players[6].score = 2;
        players[7].score = 1;

        int bSum = 0;
        int rSum = 0;
        for(Player player : players) {
            if(player.team.equals("B")) {
                bSum += player.score;
            } else {
                rSum += player.score;
            }
        }

        if(bSum == rSum) {
            System.out.println(players[0].team.equals("B") ? "Blue" : "Red" );
        } else {
            System.out.println(bSum > rSum ? "Blue" : "Red");
        }
        br.close();
    }
}