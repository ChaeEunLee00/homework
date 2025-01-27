import java.io.*;
import java.util.*;

public class Main{

    public static Character[][] field = new Character[12][6];
    public static int[] dY = {1, -1, 0, 0};
    public static int[] dX = {0, 0, 1, -1};

    public static class Point{
        int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 12; i++){
            String line = br.readLine();
            for(int j = 0; j < 6; j++){
                field[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        while(removePoint()){
            // 연쇄 횟수 증가
            count++;

            // 필드 업데이트
            updateField();
        }

        System.out.println(count);
        br.close();
    }

    public static boolean removePoint(){
        boolean removed = false;

        int[][] visited = new int[12][6];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                if(field[i][j] == '.' || visited[i][j] != 0) continue;

                // bfs
                ArrayList<Point> list = bfs(i,j,visited);

                // 제거
                if(list.size() >= 4){
                    removed = true;
                    for(int l = 0; l < list.size(); l++){
                        Point point = list.get(l);
                        field[point.y][point.x] = '.';
                    }
                }

            }
        }
        return removed;
    }

    public static ArrayList<Point> bfs(int i, int j, int[][] visited){
        ArrayList<Point> list = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));
        visited[i][j] = 1;

        while(!q.isEmpty()){
            Point point = q.remove();
            list.add(point);

            for(int d = 0; d < 4; d++){
                int nextY = point.y + dY[d];
                int nextX = point.x + dX[d];

                if(nextY >= 0 && nextX >= 0 && nextY < 12 && nextX < 6 && visited[nextY][nextX] == 0
                        && field[point.y][point.x] == field[nextY][nextX]){
                    q.add(new Point(nextY, nextX));
                    visited[nextY][nextX] = 1;
                }
            }
        }

        return list;
    }

    public static void updateField(){
        // 열에 대해 탐색
        for(int x = 0; x < 6; x++){
            Queue<Character> columnValues = new LinkedList<>();

            for(int y = 0; y < 12; y++){
                if(field[y][x] != '.') columnValues.add(field[y][x]);
            }

            int idx = columnValues.size();
            if(idx == 0) continue;

            for(int y = 0; y < 12 - idx; y++){
                field[y][x] = '.';
            }

            for(int y = 12 - idx; y < 12; y++){
                field[y][x] = columnValues.remove();
            }
        }
    }
}