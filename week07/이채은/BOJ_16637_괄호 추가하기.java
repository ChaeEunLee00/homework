import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static char[] ops;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N/2+1];
        ops = new char[N/2];
        String line = br.readLine();
        for(int i = 0; i < N; i++){
            if(i%2 == 0) nums[i/2] = line.charAt(i) -'0';
            else ops[i/2] = line.charAt(i);
        }

        getMax(0, nums[0]);
        System.out.println(max);
    }

    public static void getMax(int idx, int result){
        if(idx == N/2){
            max = Math.max(max, result);
            return;
        }

        // 괄호 x
        int num = calculate(ops[idx], result, nums[idx+1]);
        getMax(idx+1, num);

        // 괄호 ㅇ
        if(idx+1 != N/2){
            num = calculate(ops[idx+1], nums[idx+1], nums[idx+2]);
            num = calculate(ops[idx], result, num);
            getMax(idx+2, num);
        }
    }

    public static int calculate(char ops, int a, int b){
        if(ops == '+') return a+b;
        else if(ops == '-') return a-b;
        else return a*b;
    }
}