import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < N; i++){
            char cur = line.charAt(i);
            while(!stk.isEmpty() && stk.peek() < cur && K > 0){
                stk.pop();
                K--;
            }
            stk.push(cur);
        }

        // K가 0이상일 때 남은 것 처리
        while(K != 0){
            stk.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        System.out.println(sb.reverse());
        br.close();
    }
}