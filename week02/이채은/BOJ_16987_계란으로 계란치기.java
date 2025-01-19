import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[][] eggs;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        eggs = new int[N][2];
        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        // 0번 계란을 잡음, 현재까지 0개의 계란이 깨짐
        bt(0,0);

        System.out.println(max);
        br.close();
    }

    static void bt(int num, int count){
        // 마지막 계란까지 다 잡았으면, max 업데이트
        if(num == N) {
            max = Math.max(max, count);
            return;
        }

        // 잡은 계란이 깨져있거나, 나머지 계란이 다 깨졌으면 그냥 넘어감
        if(eggs[num][0] <= 0 || count == N-1){
            bt(num+1, count);
            return;
        }

        // 잡은 계란으로, 처음부터 차례대로 깨보자
        int originalCount = count;
        for(int i = 0; i < N; i++){
            // 잡은 계란일 경우 pass
            if(i == num) continue;
            // 깨진 계란일 경우 pass
            if(eggs[i][0] <= 0) continue;

            // 계란 깨기
            eggs[i][0] -= eggs[num][1];
            eggs[num][0] -= eggs[i][1];

            // 깨졌는지 확인하기
            if(eggs[i][0] <= 0) count++;
            if(eggs[num][0] <= 0) count++;

            // 다음 계란으로 똑같이 진행하기
            bt(num+1, count);

            // 다음 for문을 위해 원래대로
            eggs[i][0] += eggs[num][1];
            eggs[num][0] += eggs[i][1];
            count = originalCount;
        }
    }
}