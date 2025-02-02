import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });  //2차원 배열 정렬

        int x = arr[0][0];
        int y = arr[0][1];
        int len = y-x;
        for(int i = 0; i < N; i++){
            if(x <= arr[i][0] && arr[i][1] <= y) { //포함된 경우
                continue;
            } else if(arr[i][0] < y) { //일부만 포함된 경우
                len += arr[i][1] - y;
            } else { //겹치는 부분이 없는 경우
                len += arr[i][1] - arr[i][0];
            }
            x = arr[i][0];
            y = arr[i][1];
        }
        System.out.println(len);
    }
}
