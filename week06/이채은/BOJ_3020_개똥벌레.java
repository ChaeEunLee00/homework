import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];
        for(int i = 0; i < N/2; i++){
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int h = 1; h < H+1; h++){
            int rockCount = count(0,N/2-1,h,down) + count(0,N/2-1,H-h+1,up);

            if(rockCount < min){
                min = rockCount;
                cnt = 1;
            }
            else if(rockCount == min) cnt++;
        }

        sb.append(min).append(" ").append(cnt);
        System.out.println(sb.toString());
    }

    public static int count(int left, int right, int h, int[] rocks){
        while(left <= right){
            int mid = (left + right) / 2;

            if(rocks[mid] < h) left = mid+1;
            else right = mid-1;
        }
        return rocks.length-right-1;
    }
}