import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String S = sc.next();
            String T = sc.next();

            int index = 0;
            if(S.contains("x")) index = S.indexOf("x");
            else if(S.contains("X")) index = S.indexOf("X");
            else if(S.contains("y")) index = S.indexOf("y");
            else if(S.contains("Y")) index = S.indexOf("Y");

            sb.append(T.charAt(index));
        }

        System.out.println(sb.toString().toUpperCase());

    }
}