import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer current = new StringTokenizer(br.readLine());
        StringTokenizer right = new StringTokenizer(br.readLine());

        int[] diff = new int[N];
        for(int i = 0; i < N; i++){
            diff[i] = Integer.parseInt(right.nextToken()) - Integer.parseInt(current.nextToken());
        }

        int[] optimalCount = new int[N];
        optimalCount[0] = Math.abs(diff[0]);
        for(int i = 1; i < N; i++){
            if(diff[i-1] * diff[i] > 0){
                if(Math.abs(diff[i]) <= Math.abs(diff[i-1])) optimalCount[i] = optimalCount[i-1];
                else optimalCount[i] = optimalCount[i-1] + Math.abs(diff[i]-diff[i-1]);
            } else{
                optimalCount[i] = optimalCount[i-1] + Math.abs(diff[i]);
            };
        }

        System.out.println(optimalCount[N-1]);
    }
}