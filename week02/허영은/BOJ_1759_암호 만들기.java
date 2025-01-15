import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] key;
    static char[] alphas;

    public static void generateKey(int start, int length) {
        if(length == L) {
            if(checkKey()) System.out.println(String.valueOf(key));
            return;
        }

        for(int i = start; i < C; i++) {
            key[length] = alphas[i];
            generateKey(i + 1, length + 1);
        }
    }

    public static boolean checkKey() {
        int mo = 0;
        int ja = 0;

        for (char c : key) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u') mo++;
            else ja++;
        }

        return (1 <= mo && 2 <= ja);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphas = reader.readLine().replace(" ", "").toCharArray();
        Arrays.sort(alphas);

        /*
        * 암호 규칙
        * 1. L개로 구성
        * 2. 최소 한개의 모음 + 최소 두개의 자음으로 구성
        * 3. 오름차순 정렬
        */
        key = new char[L];
        generateKey(0, 0);
    }
}
