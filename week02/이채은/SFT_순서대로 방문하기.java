import java.io.*;
import java.util.*;

public class Main {

    static int[][] point;
    static int n;
    static int m;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        point = new int[m][2];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            point[i][0] = x;
            point[i][1] = y;
        }

        int currentX = point[0][0];
        int currentY = point[0][1];
        int nextIdx = 1;
        bt(currentX, currentY, nextIdx, map); // 현재위치, 다음도착위치

        System.out.println(count);
        br.close();
    }

    static void bt(int currentX, int currentY, int nextIdx, int[][] map){
        // nextIdx==m count++
        if(nextIdx == m){
            count++;
            return;
        }

        // 벽이거나 맵을 벗어난 경우
        if(currentX >= n || currentX < 0 || currentY >= n || currentY < 0 || map[currentX][currentY] == 1) return;

        // 다음 방문지점에 도착한 경우
        // currentpoint==nextIdxpoint bt(current, nextIdx++, count)
        if(currentX == point[nextIdx][0] && currentY == point[nextIdx][1]){
            bt(currentX, currentY, nextIdx + 1, map);
            return;
        }


        // 방문했으면 0->1 처리
        map[currentX][currentY] = 1;

        //움직이기
        bt(currentX+1, currentY, nextIdx, map);
        bt(currentX-1, currentY, nextIdx, map);
        bt(currentX, currentY+1, nextIdx, map);
        bt(currentX, currentY-1, nextIdx, map);

        // 백트랙킹을 위한 원상복구
        map[currentX][currentY] = 0;

    }
}