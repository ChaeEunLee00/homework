import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] ability;

    static boolean[] isSelected;
    static int min =  Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ability = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[N];
        visit(0);
        System.out.println(min);
    }

    public static void visit(int idx){
        if(idx == N){
            int start = 0;
            int link = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(isSelected[i] == isSelected[j]){
                        if(isSelected[i]) start += ability[i][j];
                        else link += ability[i][j];
                    }
                }
            }

            min = Math.min(min, Math.abs(start-link));
            return;
        }
        // 선택 ㅇ
        isSelected[idx] = true;
        visit(idx+1);
        // 선택 x
        isSelected[idx] = false;
        visit(idx+1);
    }
}