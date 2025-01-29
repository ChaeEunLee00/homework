import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] PHs = new int[N];
        String line = br.readLine();
        for(int i = 0; i < N; i++){
            if(line.charAt(i) == 'P') PHs[i] = 2;
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            if(PHs[i] != 2) continue;

            for(int j = i-K; j <= i+K; j++){
                if(j < 0 || j >= N || PHs[j] != 0) continue;
                PHs[j] = 1;
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}
