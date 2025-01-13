import java.util.*;

public class Main {

	public static void main(String[] args) {
	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());

    int costPer[][] = new int[N][3];  // 각각의 집마다 R, G, B를 칠하는 데에 필요한 금액
		int costAll[][] = new int[N][3];  // 전체 금액
		
		for(int i = 0; i < N; i++) { 
      String input = reader.readLine();
			costPer[i][0] = (Integer.parseInt(input.split(" ")[0]));
			costPer[i][1] = (Integer.parseInt(input.split(" ")[1]));
			costPer[i][2] = (Integer.parseInt(input.split(" ")[2]));
		}

		costAll[0][0] = costPer[0][0];  
		costAll[0][1] = costPer[0][1];
		costAll[0][2] = costPer[0][2];
		
		for(int i = 1; i < N; i++) {    // 두번째 집부터 
			costAll[i][0] = costPer[i][0] + Math.min(costAll[i-1][1], costAll[i-1][2]);
			costAll[i][1] = costPer[i][1] + Math.min(costAll[i-1][0], costAll[i-1][2]);
			costAll[i][2] = costPer[i][2] + Math.min(costAll[i-1][1], costAll[i-1][0]);
		}
		int ans = Math.min(Math.min(costAll[N-1][0], costAll[N-1][1]), costAll[N-1][2]);
		
		System.out.println(ans);
		
	}

}
