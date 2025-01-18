import java.util.*;

public class Main{

    public static int N;
    public static int[] columns;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        columns = new int[N];

        bt(0);

        System.out.println(answer);
        sc.close();
    }

    public static void bt(int currentRow){
        if(currentRow == N){
            answer++;
            return;
        }

        for(int c = 0; c < N; c++){
            if(isPossible(currentRow,c)){
                columns[currentRow] = c;
                bt(currentRow+1);
            }
        }
    }

    public static boolean isPossible(int r, int c){
        for(int i = 0; i < r; i++){
            if(columns[i] == c) return false;
            if(Math.abs(r-i) == Math.abs(c-columns[i])) return false;
        }
        return true;
    }
}