import java.io.*;
import java.util.*;

public class Main {
    static int[] dY = {1, -1, 0, 0};
    static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> fires = new ArrayDeque<>();
        for(int r = 0; r < R; r++){
            String line = br.readLine();
            for(int c = 0; c < C; c++){
                map[r][c] = line.charAt(c);

                if(map[r][c] == 'J'){
                    q.offer(new int[]{r, c});
                }
                else if(map[r][c] == 'F'){
                    fires.offer(new int[]{r, c});
                }
            }
        }

        int time = 1;
        while(!q.isEmpty()){
            // 불 확산
            int fireSize = fires.size();
            while(fireSize != 0){
                int[] currentFire = fires.poll();

                // next 담기
                // 밖이거나 벽이거나 불이면 확산 x
                for(int d = 0; d < 4; d++){
                    int nextY = currentFire[0] + dY[d];
                    int nextX = currentFire[1] + dX[d];

                    if(nextY < 0 || nextX < 0 || nextY >= R || nextX >= C ||
                            map[nextY][nextX] == '#' || map[nextY][nextX] == 'F') continue;

                    fires.offer(new int[]{nextY, nextX});
                    map[nextY][nextX] = 'F';
                }
                fireSize--;
            }

            // q의 size만큼 loop
            int size = q.size();
            while(size != 0){
                int[] current = q.poll();

                // next 담기
                // 밖이면 탈출(break)
                // 불이나 벽이나 J면 못가고 - J는 방문했다는 표시
                for(int d = 0; d < 4; d++){
                    int nextY = current[0] + dY[d];
                    int nextX = current[1] + dX[d];

                    if(nextY < 0 || nextX < 0 || nextY >= R || nextX >= C){
                        System.out.println(time);
                        return;
                    }

                    if(map[nextY][nextX] == '#' || map[nextY][nextX] == 'F' || map[nextY][nextX] == 'J') continue;
                    q.offer(new int[]{nextY, nextX});
                    map[nextY][nextX] = 'J';
                }
                size--;
            }

            time++;
        }

        System.out.println("IMPOSSIBLE");
    }
}