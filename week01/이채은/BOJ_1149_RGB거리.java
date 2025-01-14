import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // red = 0, green = 1, blue = 2
        int[][] cost = new int[N][3];

        for(int i = 0; i < N; i++){
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        // 행은 N, 열은 RGB
        // dp[i][j]= i번째집을 j색으로 칠할 때 최솟값
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // dp[i][j] = min(dp[i-1][a],dp[i-1][b]) + cost[i][j] => a,b는 j를 제외한 색
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]), dp[N-1][2]));
        sc.close();
    }
}