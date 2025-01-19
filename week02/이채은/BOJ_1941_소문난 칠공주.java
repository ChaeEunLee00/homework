import java.io.*;
import java.util.*;

public class Main{
    public static int answer = 0;
    public static Character[][] classroom = new Character[5][5];
    public static boolean[] selected = new boolean[25];
    public static int[] directionY = {-1, 1, 0, 0};
    public static int[] directionX = {0, 0, -1, 1};

    public static class Point{
        int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i ++){
            String line = br.readLine();
            for(int j = 0; j < 5; j++){
                classroom[i][j] = line.charAt(j);
            }
        }

        // 이다솜파가 최소 4명인 7명 조합 만들기(백트랙킹) -> 인접하는지 확인(bfs)
        bt(0,0,0);

        System.out.println(answer);
        br.close();
    }

    public static void bt(int idx, int sNum, int yNum){
        if(yNum > 3) return;
        else if(sNum + yNum == 7){
            int preIdx = idx-1;
            if(bfs(preIdx/5, preIdx%5)){
                answer++;
            }
            return;
        }

        // 5*y + x
        for(int i = idx; i < 25; i++){
            selected[i] = true;

            if(classroom[i/5][i%5] == 'Y') bt(i+1, sNum, yNum+1);
            else bt(i+1, sNum+1, yNum);

            selected[i] = false;
        }
    }

    public static boolean bfs(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y,x));

        boolean[][] visited = new boolean[5][5];
        visited[y][x] = true;

        int count = 0;
        while(!q.isEmpty()){
            Point point = q.poll();
            count++;

            for(int i = 0; i < 4; i++){
                int nextY = point.y + directionY[i];
                int nextX = point.x + directionX[i];

                if(nextY >= 0 && nextX >= 0 && nextY < 5 && nextX < 5){
                    if(!visited[nextY][nextX] && selected[nextY * 5 + nextX]){
                        q.add(new Point(nextY,nextX));
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
        return count == 7;
    }
}