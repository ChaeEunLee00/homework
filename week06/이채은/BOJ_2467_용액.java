import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        long sol1 = 0;
        long sol2 = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0; i < N-1; i++){
            long target = solutions[i];

            int left = i+1;
            int right = N-1;
            while(left <= right){
                int mid = (left + right) / 2;

                long sum = Math.abs(target + solutions[mid]);
                if(sum < min){
                    min = sum;
                    sol1 = target;
                    sol2 = solutions[mid];
                }

                if(solutions[mid] < -target) left = mid+1;
                else right = mid-1;
            }
        }

        sb.append(sol1).append(" ").append(sol2);
        System.out.println(sb.toString());
    }
}