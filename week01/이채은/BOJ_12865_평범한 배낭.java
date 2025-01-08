import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] WV = new int[N+1][2];
        for(int i = 1; i < N+1; i++){
            WV[i][0] = sc.nextInt();
            WV[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N+1][K+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < K+1; j++){

                if(WV[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max( WV[i][1] + dp[i-1][j-WV[i][0]], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[N][K]);
        sc.close();
    }
}