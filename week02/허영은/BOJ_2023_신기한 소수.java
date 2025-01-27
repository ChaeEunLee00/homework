import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int n; // 자리수
	private static StringBuilder sb = new StringBuilder();
	private static int[] lastNum = new int[] {1, 3, 7, 9}; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[] primeNum = new int[] {2, 3, 5, 7}; 

		for (int i : primeNum) { 
			dfs(1, i);
		}
		System.out.print(sb); 
	}

	/**
	 * 백트래킹
	 */
	private static void dfs(int cnt, int num) {

		if (cnt == n) { 
			sb.append(num).append("\n");
			return;
		}

		for (int i = 0; i < 4; i++) { // 1,3,7,9
			int candidate = num * 10 + lastNum[i];
			if (isPrime(candidate)) { 
				dfs(cnt + 1, candidate);
			}
		}
	}

	/**
	 * 소수 인지
	 */
	private static boolean isPrime(int num) {

		for (int i = 3; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false; // 소수 X
			}
		}
		return true; // 소수
	}

}
