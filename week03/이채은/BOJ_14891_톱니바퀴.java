import java.io.*;
import java.util.*;

public class Main{

    public static int[][] gear = new int[4][8];
    public static int[] startIdx = new int[4];

    public static class RotateInfo{
        int gearNum;
        int direction;

        public RotateInfo(int gearNum, int direction){
            this.gearNum = gearNum;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            String line = br.readLine();
            for(int j = 0; j < 8; j++){
                gear[i][j] = line.charAt(j)- '0';
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken());
            rotateGear(gearNum,direction);
        }

        int answer = 0;
        for(int i = 0; i < 4; i++){
            if(gear[i][startIdx[i]] == 1) answer += Math.pow(2,i);
        }
        System.out.println(answer);
    }

    public static void rotateGear(int gearNum, int direction){
        Queue<RotateInfo> q = new LinkedList<>();
        q.add(new RotateInfo(gearNum, direction));

        int[] visited = new int[4];
        visited[gearNum] = 1;
        while(!q.isEmpty()){

            RotateInfo rotateInfo = q.remove();
            gearNum = rotateInfo.gearNum;
            direction = rotateInfo.direction;

            // 회전할 양 옆 톱니바퀴 저장
            int left = gearNum - 1;
            if(left >= 0 && visited[left] == 0 &&
                    gear[left][(startIdx[left]+2)%8] != gear[gearNum][(startIdx[gearNum]+6)%8]){
                q.add(new RotateInfo(left, direction * -1));
                visited[left] = 1;
            }

            int right = gearNum + 1;
            if(right < 4 && visited[right] == 0 &&
                    gear[right][(startIdx[right]+6)%8] != gear[gearNum][(startIdx[gearNum]+2)%8]){
                q.add(new RotateInfo(right, direction * -1));
                visited[right] = 1;
            }

            // 회전
            if(direction == 1) startIdx[gearNum]--;
            else startIdx[gearNum]++;

            // 인덱스 조정
            if(startIdx[gearNum] == -1) startIdx[gearNum] = 7;
            else if(startIdx[gearNum] == 8) startIdx[gearNum] = 0;
        }
    }
}