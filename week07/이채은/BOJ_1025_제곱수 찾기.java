import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = line.charAt(0) - '0';
        int M = line.charAt(2) - '0';

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            line = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int max = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int di = -N; di < N; di++){
                    for(int dj = -M; dj < M; dj++){
                        if(di == 0 && dj == 0) continue;

                        // 시작점 세팅
                        int row = i;
                        int col = j;
                        int num = 0;
                        while(row >= 0 && row < N && col >= 0 && col < M){
                            num = num*10 + arr[row][col];
                            if(isPerfectSquare(num)) max = Math.max(max, num);

                            row += di;
                            col += dj;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isPerfectSquare(int num){
        int n = (int) Math.sqrt(num);
        return n * n == num;
    }
}