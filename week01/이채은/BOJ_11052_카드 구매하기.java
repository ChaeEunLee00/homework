import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cost = new int[N];
        for(int i = 0; i < N; i++){
            cost[i] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        for(int i = 1; i < N+1; i++){
            dp[i] = cost[i-1];
            for(int j = 1; j < i/2+1; j++){
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            }
        }

        System.out.println(dp[N]);
        sc.close();
    }
}