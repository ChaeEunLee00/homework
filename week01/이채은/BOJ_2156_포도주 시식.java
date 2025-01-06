import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        // 1~3잔 예외처리
        if (N == 1) {
            answer = arr[0];
        } else if (N == 2) {
            answer = arr[0] + arr[1];
        } else if (N == 3) {
            answer = Math.max(arr[0] + arr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));
        } else {
            // 4잔~

            // 1~3잔 dp값 설정
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

            // dp[i] = (arr[i]+arr[i-1]+dp[i-3], arr[i]+ dp[i-2], dp[i-1]) 중에 최댓값
            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3]));
            }

            answer = dp[N-1];
        }

        // 출력
        System.out.println(answer);

    }
}