import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] spaces = new int[M][N];
        for(int i = 0; i < M; i++){
            // 우주 입력값 받기
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                spaces[i][j] = Integer.parseInt(st.nextToken());
                set.add(spaces[i][j]);
            }

            // 좌표 압축
            ArrayList<Integer> base = new ArrayList<>(set);
            Collections.sort(base);
            for(int j = 0; j < N; j++){
                spaces[i][j] = binarySearch(base, spaces[i][j]);
            }
        }

        // 균등한 우주 count
        int count = 0;
        for(int i = 0; i < M; i++){
            for(int j = i+1; j < M; j++){
                if(isSame(spaces[i], spaces[j])) count++;
            }
        }

        System.out.println(count);
    }

    public static int binarySearch(ArrayList<Integer> base, int num){
        int left = 0;
        int right = base.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(base.get(mid) < num) left = mid+1;
            else right = mid;
        }
        return right;
    }

    public static boolean isSame(int[] A, int[]B){
        for(int i = 0; i < A.length; i++){
            if(A[i] != B[i]) return false;
        }
        return true;
    }
}