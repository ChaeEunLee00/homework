import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < 0) left.add(Math.abs(num));
            else right.add(num);
        }

        Collections.sort(left);
        Collections.sort(right);

        int totalStep = 0;

        // left
        int leftSize = left.size();
        for(int i = leftSize-1-M; i >=0; i -= M){
            totalStep += left.get(i)*2;
        }
        // right
        int rightSize = right.size();
        for(int i = rightSize-1-M; i >=0; i -= M){
            totalStep += right.get(i)*2;
        }

        int leftMax = 0;
        int rightMax = 0;
        if(leftSize != 0) leftMax = left.get(leftSize-1);
        if(rightSize != 0) rightMax = right.get(rightSize-1);

        if(leftMax < rightMax){
            totalStep += leftMax*2 + rightMax;
        } else{
            totalStep += rightMax*2 + leftMax;
        }

        System.out.println(totalStep);
        br.close();
    }
}