import java.io.*;
import java.util.*;

public class Main {
    // 좌 -> 하 -> 우 -> 상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] sdy = {
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}
    };
    static int[][] sdx = {
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}
    };
    static int[] per = {1, 1, 2, 2, 7, 7, 10, 10, 5, 0};

    static int N;
    static int[][] A;
    static int sandOver;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(N/2, N/2);
        System.out.println(sandOver);
    }

    public static void move(int y, int x){
        int[] moveCnt = {1, 1, 2, 2};

        while(true){
            for(int d = 0; d < 4; d++){
                for(int i = 0; i < moveCnt[d]; i++){
                    y += dy[d];
                    x += dx[d];
                    spread(y, x, d);

                    if(y == 0 && x == 0) return;
                }
            }

            for(int d = 0; d < 4; d++){
                moveCnt[d] += 2;
            }
        }
    }

    public static void spread(int y, int x, int d){
        int sand = A[y][x];
        A[y][x] = 0;

        int perY = 0;
        int perX = 0;
        int movedSand = 0;
        for(int i = 0; i < 10; i++){
            perY = y + sdy[d][i];
            perX = x + sdx[d][i];

            if(i == 9){
                if(!isValid(perY,perX)){
                    sandOver += sand - movedSand;
                } else{
                    A[perY][perX] += sand - movedSand;
                }
            } else{
                int perSand = sand * per[i] / 100;
                if(!isValid(perY,perX)){
                    sandOver += perSand;
                } else{
                    A[perY][perX] += perSand;
                }
                movedSand += perSand;
            }
        }
    }

    public static boolean isValid(int y, int x){
        if(y >= 0 && y < N && x >= 0 && x < N) return true;
        else return false;
    }
}