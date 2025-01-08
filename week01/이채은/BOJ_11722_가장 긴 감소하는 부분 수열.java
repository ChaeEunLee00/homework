import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        for(int i = 0; i < N; i++){
            dp[i] = 1;
        }

        //A[i] 보다 앞에 있고, 더 큰 수의 dp 값 중 최댓값 + 1 = dp[i]
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(A[j] > A[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[N-1]);
        sc.close();

    }
}