import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Point> viruses;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    public static class Point{
        public int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        viruses = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) map[i][j] = -1;
                else if (num == 2) viruses.add(new Point(i,j));
            }
        }

        boolean[] visited = new boolean[viruses.size()];
        setVirus(0, 0, visited);

        // 최소값이 max value이면 -1 아니면 최소갑사 출력
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void setVirus(int idx, int cnt, boolean[] visited){
        if(cnt == M){
            bfs(visited);
            return;
        }

        if(idx == visited.length) return;
        visited[idx] = true;
        setVirus(idx+1, cnt+1, visited);
        visited[idx] = false;
        setVirus(idx+1, cnt, visited);
    }

    public static void bfs(boolean[] visited){
        // visited를 통해 시작점 큐 생성
        boolean[][] mapVisited = new boolean[N][N];
        Queue<Point> q = new ArrayDeque<>();
        for(int i = 0; i < visited.length; i++){
            if(visited[i]){
                Point virus = viruses.get(i);
                q.offer(virus);
                mapVisited[virus.y][virus.x] = true;
            }
        }

        // bfs 진행
        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Point virus = q.poll();

                for(int d = 0; d < 4; d++){
                    int nextY = virus.y + dy[d];
                    int nextX = virus.x + dx[d];

                    if(!isValid(nextY, nextX) || map[nextY][nextX] == -1 || mapVisited[nextY][nextX]) continue;
                    q.offer(new Point(nextY,nextX));
                    mapVisited[nextY][nextX] = true;
                }
                size--;
            }
            time++;
        }

        // 모두 전염되었는지 확인 => 벽이 아닌데 방문 안한곳이 있다면 전염 x
        // true 이면 시간 초 최솟값 갱신
        if(isAllInfected(mapVisited)){
            min = Math.min(min, time);
        }
    }

    public static boolean isValid(int y, int x){
        if(y >= 0 && y < N && x >= 0 && x < N) return true;
        else return false;
    }

    public static boolean isAllInfected(boolean[][] mapVisited){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != -1 && !mapVisited[i][j]) return false;
            }
        }
        return true;
    }
}