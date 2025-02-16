import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(arr[0]);
        for(int i = 1; i < N; i++){
            int cur = arr[i];
            int lastest = LIS.get(LIS.size()-1);

            if(cur > lastest){
                LIS.add(cur);
            }
            else if(cur < lastest){
                // 이분탐색
                int left = 0;
                int right = LIS.size()-1;

                while(left <= right){
                    int mid = (left + right) / 2;

                    if(LIS.get(mid) < cur) left = mid+1;
                    else right = mid-1;
                }

                LIS.set(left,cur);
            }
        }

        System.out.println(LIS.size());
    }
}