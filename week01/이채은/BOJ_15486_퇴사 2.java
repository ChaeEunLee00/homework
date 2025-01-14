import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int[] update = new int[N+1];
        for(int i = 0; i < N+1; i++){
            if(update[i] > max) max = update[i];

            int next = i + schedule[i][0];
            int cost = schedule[i][1];
            if(next < N+1)
                update[next] = Math.max(update[next], max + cost);
        }

        System.out.println(max);
        br.close();
    }
}