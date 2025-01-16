import java.io.*;
import java.util.*;

public class Main{

    static int L;
    static int C;
    static Character[] alphabet;
    static String vowel = "aeiou";
    static ArrayList<String> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new Character[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet); //오름차순

        int idx = 0; // 현재 알파벳 인덱스
        int currentV = 0;
        int currentC = 0;
        bt(idx, currentV, currentC); // 모음, 자음

        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }
        br.close();
    }

    static void bt(int idx, int currentV, int currentC){
        if(currentV + currentC == L){
            if(currentV >= 1 && currentC >=2){
                answer.add(sb.toString());
                return;
            } else return;
        }
        else if(idx == C) return;

        for(int i = idx; i < C; i++){
            sb.append(alphabet[i]);

            if(vowel.contains(alphabet[i]+"")) bt(i+1, currentV+1, currentC);
            else bt(i+1, currentV, currentC+1);

            sb.deleteCharAt(sb.length()-1);
        }
    }
}