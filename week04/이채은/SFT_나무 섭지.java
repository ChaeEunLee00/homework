import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;

    public static int endY = 0;
    public static int endX = 0;

    public static class Point{
        int y,x,time;
        public Point(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startY = 0;
        int startX = 0;
        ArrayList<Integer[]> ghosts = new ArrayList<>();

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();

            for(int j = 0; j < M; j++){
                Character c = line.charAt(j);

                if(c == '#'){
                    map[i][j] = 1;
                }
                else if(c == 'N'){
                    startY = i;
                    startX = j;
                } else if(c == 'D'){
                    endY = i;
                    endX = j;
                } else if(c == 'G'){
                    ghosts.add(new Integer[]{i,j});
                }
            }
        }

        // 남우->출구 최단시간 계산
        int nMinTime = bfs(startY, startX);

        // 출구로 도달할 수 없는 경우
        if(nMinTime == -1){
            System.out.println("No");
            return;
        }

        // 고스트->출구 최단시간 계산
        int gMinTime = Integer.MAX_VALUE;
        for(int i = 0; i < ghosts.size(); i++){
            Integer[] ghost = ghosts.get(i);
            int gTime = Math.abs(ghost[0]-endY) + Math.abs(ghost[1]-endX);
            if(gTime < gMinTime) gMinTime = gTime;
        }

        // 남우가 고스트보다 더 빨리 도착하면 탈출
        if(nMinTime < gMinTime) System.out.println("Yes");
        else System.out.println("No");

        br.close();
        return;
    }

    public static int bfs(int currentY, int currentX){
        int[] dY = {1, -1, 0, 0};
        int[] dX = {0, 0, 1, -1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(currentY, currentX, 0));
        map[currentY][currentX] = 1;

        while(!q.isEmpty()){
            Point point = q.remove();

            for(int d = 0; d < 4; d++){
                int nextY = point.y + dY[d];
                int nextX = point.x + dX[d];

                if(nextY == -1 || nextX == -1 || nextY == N || nextX == M || map[nextY][nextX] == 1) continue;
                if(nextY == endY && nextX == endX) return point.time + 1;

                q.add(new Point(nextY, nextX, point.time+1));
                map[nextY][nextX] = 1;
            }
        }
        return -1;
    }
}
