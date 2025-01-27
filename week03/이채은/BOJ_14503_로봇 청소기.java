import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int M;
    public static int r;
    public static int c;
    public static int d;
    public static int[][] room;
    public static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N,M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // robot의 r,c,d
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // room
        room = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();

        System.out.println(count);
        br.close();
    }

    public static void clean(){
        int[] dR = {1, -1, 0, 0};
        int[] dC = {0, 0, 1, -1};

        while(true){
            // 현재 칸 청소 - 2로 표시
            if(room[r][c] == 0){
                room[r][c] = 2;
                count++;
            }

            // 주변 탐색
            boolean isAllCleaned = true;
            for(int i = 0; i < 4; i++){
                int nextR = r + dR[i];
                int nextC = c + dC[i];
                if(room[nextR][nextC] == 0){
                    isAllCleaned = false;
                    break;
                }
            }

            // 1. 빈칸이 없다면 (다 청소 되었다면 or 벽)
            if(isAllCleaned){
                // 한칸후진
                int reverseD = (d+2)%4;
                if(reverseD == 0) r--;
                else if(reverseD == 1) c++;
                else if(reverseD == 2) r++;
                else if(reverseD == 3) c--;

                // 후진 불가 시 작동 멈춤
                if(room[r][c] == 1) break;
            }
            // 2. 빈칸이 있다면
            else{
                // 반시계 방향으로 90도 회전
                if(d == 0) d = 3;
                else d--;

                // 바라보는 방향의 칸이 빈칸이면 전진
                if(d == 0 && room[r-1][c] == 0) r--;
                else if(d == 1 && room[r][c+1] == 0) c++;
                else if(d == 2 && room[r+1][c] == 0) r++;
                else if(d == 3 && room[r][c-1] == 0) c--;
            }
        }
    }
}