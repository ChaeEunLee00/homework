import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static ArrayList<Rank> rank;

    public static class Rank implements Comparable<Rank>{
        int document, interview;

        public Rank(int document, int interview){
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Rank o){
            return this.document - o.document;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++){
            N = Integer.parseInt(br.readLine());

            rank = new ArrayList<>();
            for(int n = 0; n < N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());
                rank.add(new Rank(d,i));
            }

            sb.append(recruit()).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    public static int recruit(){
        // 서류 결과로 오름차순 정렬
        Collections.sort(rank);

        // 서류 기준 자신 보다 위에 있는 사람들의 면접 결과 중 highest보다 높아야 합격
        int count = 1;
        int highest = rank.get(0).interview;
        for(int i = 1; i < N; i++){
            Rank curR = rank.get(i);
            if(curR.interview < highest){
                count++;
                highest = curR.interview;
            }
        }
        return count;
    }
}