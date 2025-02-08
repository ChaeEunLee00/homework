import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int minDistance = Integer.MAX_VALUE;

    public static int[] dY = {1, -1, 0, 0};
    public static int[] dX = {0, 0, 1, -1};

    public static class Point{
        int y,x,depth,isBroken;
        public Point(int y, int x, int depth, int isBroken){
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }

        bfs();
        System.out.println(minDistance != Integer.MAX_VALUE ? minDistance : -1);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,1,0));

        boolean[][][] visited = new boolean[N][M][2]; // 0: 부수지 않은 채로 방문, 1: 부순 채로 방문
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point current = q.poll();
            if(current.y == N-1 && current.x == M-1){
                minDistance = current.depth;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextY = current.y + dY[d];
                int nextX = current.x + dX[d];

                if (!isValid(nextY, nextX)) continue;

                // 벽이면
                // 지금까지 부쉈는지 여부 확인, 현재 칸에 부순 채로 방문햇는지 확인
                // 지금까지 안 부쉈고, 현재 칸에 부순 채로 방문한 적도 없으면, 부수고 진행
                if(map[nextY][nextX] == 1){
                    if(current.isBroken == 0 && !visited[nextY][nextX][1]){
                        visited[nextY][nextX][1] = true;
                        q.offer(new Point(nextY,nextX,current.depth+1,1));
                    }
                }
                // 벽이 아니면
                // 지금까지 부쉈는지 여부 그대로 방문여부 확인하고, 진행
                else{
                    if(!visited[nextY][nextX][current.isBroken]){
                        visited[nextY][nextX][current.isBroken] = true;
                        q.offer(new Point(nextY,nextX,current.depth+1,current.isBroken));
                    }
                }
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 || x < 0 || y >= N || x >= M) return false;
        return true;
    }
}