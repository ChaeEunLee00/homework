import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int M;
    public static int x;
    public static int y;
    public static int[][] map;
    public static int[][] dice = new int[4][3];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < K; k++){
            int command = Integer.parseInt(st.nextToken());
            play(command);
        }

        br.close();
    }

    public static void play(int command){
        // 맵 이동
        int nextX = x;
        int nextY = y;

        if(command == 1) nextY = y+1;
        else if(command == 2) nextY = y-1;
        else if(command == 3) nextX = x-1;
        else if(command == 4) nextX = x+1;

        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
            x = nextX;
            y = nextY;
        } else return;

        // 주사위 굴리기
        dice(command);

        // 알맞은 행동 수행하기
        // 1) 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
        if(map[x][y] == 0){
            map[x][y] = dice[3][1];
        }
        // 2) 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0
        else {
            dice[3][1] = map[x][y];
            map[x][y] = 0;
        }

        // 맨 윗면 출력하기
        System.out.println(dice[1][1]);
    }

    public static void dice(int command){
        // top: dice[1][1]
        // bottom: dice[3][1]

        if(command == 1) {
            int temp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }
        else if(command == 2){
            int temp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }
        else if(command == 3){
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }
        else if(command == 4){
            int temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        }
    }
}