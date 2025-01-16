import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int currentNum = 0;
        int currentN = 0;
        bt(currentNum, currentN);

        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }

    static void bt(int currentNum, int currentN){
        if(currentN == N){
            answer.add(currentNum);
            return;
        }

        for(int i = 0; i < 10; i++){
            int nextNum = currentNum*10 + i;
            if(isPrime(nextNum)) bt(nextNum, currentN + 1);
        }
    }

    static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}