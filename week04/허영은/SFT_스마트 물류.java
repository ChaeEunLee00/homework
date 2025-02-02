import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        char[] str = br.readLine().toCharArray();
		
	for (int i = 0; i < N; i++) {
		if (str[i] == 'P') {
			for (int j = i - K; j <= i + K; j++) {
				if (j < 0 || j >= N){
					continue;
				}else if (str[j] == 'H') {
					str[j] = '*';
					count++;
					break;
				}
			}
		}
	}
        System.out.println(count);
    }
}
출처: https://pby0716.tistory.com/44 [Mr.비타민의 IT세상:티스토리]
