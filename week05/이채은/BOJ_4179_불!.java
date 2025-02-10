import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static String answer;
    static char[][] map;
    static Queue<Integer[]> fires = new LinkedList<>();

    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        Integer[] jStart = new Integer[2];
        for(int r = 0; r < R; r++){
            String line = br.readLine();
            for(int c = 0; c < C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'J'){
                    jStart[0] = r;
                    jStart[1] = c;
                } else if(map[r][c] == 'F'){
                    fires.offer(new Integer[]{r, c});
                }
            }
        }

        bfs(jStart);
        System.out.println(answer);
    }

    static void bfs(Integer[] jStart){

        Queue<Integer[]> q = new LinkedList<>();
        q.offer(jStart);

        int time = 1;
        while(!q.isEmpty()){
            // 불 확산
            fire();

            // q의 size만큼 loop
            int size = q.size();
            while(size != 0){
                Integer[] current = q.poll();

                // next 담기
                // 밖이면 탈출(break)
                // 불이나 벽이나 J면 못가고 - J는 방문했다는 표시
                for(int d = 0; d < 4; d++){
                    int nextY = current[0] + dY[d];
                    int nextX = current[1] + dX[d];

                    if(isOutside(nextY,nextX)){
                        answer = time+"";
                        return;
                    }

                    if(map[nextY][nextX] == '#' || map[nextY][nextX] == 'F' || map[nextY][nextX] == 'J') continue;
                    q.offer(new Integer[]{nextY, nextX});
                    map[nextY][nextX] = 'J';
                }
                size--;
            }

            time++;
        }

        answer = "IMPOSSIBLE";
    }

    static void fire(){
        int size = fires.size();
        while(size != 0){
            Integer[] currentFire = fires.poll();

            // next 담기
            // 밖이거나 벽이거나 불이면 확산 x
            for(int d = 0; d < 4; d++){
                int nextY = currentFire[0] + dY[d];
                int nextX = currentFire[1] + dX[d];

                if(isOutside(nextY,nextX) || map[nextY][nextX] == '#' || map[nextY][nextX] == 'F') continue;

                fires.offer(new Integer[]{nextY, nextX});
                map[nextY][nextX] = 'F';
            }
            size--;
        }
    }

    static boolean isOutside(int y, int x){
        if(y < 0 || x < 0 || y >= R || x >= C) return true;
        return false;
    }
}