import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null; 
		
		int[][] arr = new int[n+2][2];
		int[] dp = new int[n+2];
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i][0] = t; // 기간
			arr[i][1] = p; // 금액
		}
		
		int max = -1;
		for(int i = 1; i <= n+1; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int nextIdx = i + arr[i][0];
			if(nextIdx < n + 2) {
				dp[nextIdx] = Math.max(dp[nextIdx], max + arr[i][1]);
			}
		}
		System.out.println(dp[n+1]);
	}
}
