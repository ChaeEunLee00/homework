import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int maxLength = 0;
        int[] snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if(snacks[i] > maxLength) maxLength = snacks[i];
        }

        int start = 1;
        int end = maxLength;
        while(start <= end){
            int mid = (start+end) / 2;

            // 나눠줄 수 있는 갯수 구하기
            int num = 0;
            for(int i = N-1; i >= 0; i--){
                if(snacks[i] < mid) continue;
                num += snacks[i] / mid;
            }

            // 나눠줄 수 있는 갯수가 N 보다 크거나 같다면 start = mid+1
            // M보다 작다면 end = mid-1
            if(num >= M) start = mid+1;
            else end = mid-1;
        }

        System.out.println(start-1);
    }
}