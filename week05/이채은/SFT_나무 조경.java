import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] trees;

    public static int beautyMax = 0;
    public static boolean[][] visited;

    public static int[] dY = {1, 0};
    public static int[] dX = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        trees = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        if(N == 2) dfs(0,0,2);
        else dfs(0,0,4);

        System.out.println(beautyMax);
    }

    public static void dfs(int cnt, int beautySum, int maxCnt){
        if(cnt == maxCnt){
            beautyMax = Math.max(beautySum,beautyMax);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;

                for(int d = 0; d < 2; d++){
                    int nextY = i + dY[d];
                    int nextX = j + dX[d];

                    if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= N || visited[nextY][nextX]) continue;

                    visited[i][j] = true;
                    visited[nextY][nextX] = true;
                    dfs(cnt+1, beautySum + trees[i][j] + trees[nextY][nextX], maxCnt);
                    visited[i][j] = false;
                    visited[nextY][nextX] = false;
                }

            }
        }
    }
}
