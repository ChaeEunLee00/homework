import java.io.*;
import java.util.*;

public class Main{
    public static int M;
    public static int N;
    public static int[] dY = {1, -1, 0, 0};
    public static int[] dX = {0, 0, 1, -1};

    public static class Tomato{
        int y,x,day;

        public Tomato(int y, int x, int day){
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 토마토가 익어있다면 (= 안익은 토마토가 없다면) 0
        if(!containsZero(box)){
            System.out.println(0);
            return;
        }

        // 익은 토마토 큐에 넣은 후
        Queue<Tomato> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 1) q.offer(new Tomato(i,j,0));
            }
        }

        // bfs 진행
        int day = 0;
        while(!q.isEmpty()){
            Tomato cTomato = q.poll();
            day = cTomato.day;

            for(int d = 0; d < 4; d++){
                int nextY = cTomato.y + dY[d];
                int nextX = cTomato.x + dX[d];

                if(nextY >=0 && nextX >= 0 && nextY < N && nextX < M && box[nextY][nextX] == 0){
                    q.offer(new Tomato(nextY, nextX, cTomato.day+1));
                    box[nextY][nextX] = 1;
                }
            }
        }

        // 토마토가 모두 익지 못하는 상황이면 (= 안익은 토마토가 있다면) -1
        // 다 익었으면 day 출력
        if(containsZero(box)) System.out.println(-1);
        else System.out.println(day);
    }

    public static boolean containsZero(int[][] box){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0) return true;
            }
        }
        return false;
    }
}