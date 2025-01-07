import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int idx = str1.indexOf("X");
            if(idx == -1) idx = str1.indexOf("x");

            char c = str2.charAt(idx);
            c = Character.toUpperCase(c);

            sb.append(c);
        }

        System.out.println(sb);
    }
}
