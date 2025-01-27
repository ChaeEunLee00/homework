import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int[][] space;
    public static int time = 0;
    public static int shark_size = 2;
    public static int shark_fish_num;
    public static int shark_y;
    public static int shark_x;
    public static int[] dY = {0, 0, 1, -1};
    public static int[] dX = {1, -1, 0, 0};

    public static class Point implements Comparable<Point>{
        int y,x,distance;
        public Point(int y, int x, int distance){
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point p){
            if(this.distance != p.distance) return Integer.compare(this.distance, p.distance);
            else if(this.y != p.y) return Integer.compare(this.y, p.y);
            else return Integer.compare(this.x, p.x);
        }
    }

    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상어의 위치
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(space[i][j] == 9){
                    shark_y = i;
                    shark_x = j;
                    space[shark_y][shark_x] = 0;
                }
            }
        }

        // 먹을 물고기가 없을때까지 반복
        Point targetFish = findTargetFish();
        while(targetFish != null){
            eat(targetFish);
            targetFish = findTargetFish();
        }

        System.out.println(time);
        br.close();
    }

    public static Point findTargetFish(){
        // 우선순위 큐를 적용한 bfs
        PriorityQueue<Point> eatableFishes = new PriorityQueue<>();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(shark_y, shark_x, 0));

        int[][] visited = new int[N][N];
        visited[shark_y][shark_x] = 1;
        while(!q.isEmpty()){
            Point current = q.remove();
            if(space[current.y][current.x] != 0 && space[current.y][current.x] < shark_size) eatableFishes.add(current);

            for(int d = 0; d < 4; d++){
                int nextY = current.y + dY[d];
                int nextX = current.x + dX[d];

                if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < N &&
                        visited[nextY][nextX] == 0 && space[nextY][nextX] <= shark_size){
                    q.add(new Point(nextY, nextX, current.distance + 1));
                    visited[nextY][nextX] = 1;
                }
            }
        }
        return eatableFishes.poll();
    }

    public static void eat(Point targetFish){
        // 시간계산
        time += targetFish.distance;

        // 먹은 물고기 0으로 바꾸기
        space[targetFish.y][targetFish.x] = 0;

        // 상어 위치 바꾸기
        shark_y = targetFish.y;
        shark_x = targetFish.x;

        // 상어 크기
        shark_fish_num++;
        if (shark_fish_num == shark_size){
            shark_size++;
            shark_fish_num = 0;
        }
    }
}