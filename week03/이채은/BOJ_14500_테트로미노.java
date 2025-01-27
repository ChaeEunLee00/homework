import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int M;
    public static int[][] paper;
    public static int[][] visited;
    public static int[] dI = {0, 0, 1, -1};
    public static int[] dJ = {1, -1, 0, 0};
    public static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        findMax();

        System.out.println(max);
        br.close();
    }

    public static void findMax(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){

                visited[i][j] = 1;
                tetromino(i, j, 1, paper[i][j]);
                visited[i][j] = 0;
            }
        }
    }

    public static void tetromino(int i, int j, int depth, int sum){
        if(depth == 4){
            if(sum > max) max = sum;
            return;
        }

        for(int d = 0; d < 4; d++){
            int nextI = i + dI[d];
            int nextJ = j + dJ[d];
            if(nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < M && visited[nextI][nextJ] == 0){
                if(depth == 2){
                    visited[nextI][nextJ] = 1;
                    tetromino(i, j, depth+1, sum+paper[nextI][nextJ]);
                    visited[nextI][nextJ] = 0;
                }
                visited[nextI][nextJ] = 1;
                tetromino(nextI, nextJ, depth+1, sum+paper[nextI][nextJ]);
                visited[nextI][nextJ] = 0;
            }
        }
    }
}