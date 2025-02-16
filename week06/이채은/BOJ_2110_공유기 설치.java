import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] homes = new int[N];
        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        int left = 1;
        int right = homes[N-1] - homes[0];
        while(left <= right){
            int mid = (left + right) / 2;

            // 최소거리 mid 일 때, 설치 가능한 공유기 수
            int wifiCnt = 1;
            int prevWifi = 0;
            for(int i = 1; i < N; i++){
                if(homes[i] - homes[prevWifi] >= mid){
                    prevWifi = i;
                    wifiCnt++;
                }
            }

            if(wifiCnt >= C) left = mid+1;
            else right = mid-1;
        }
        System.out.println(left-1);
    }
}