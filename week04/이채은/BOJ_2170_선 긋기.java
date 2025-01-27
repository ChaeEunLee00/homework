import java.io.*;
import java.util.*;

public class Main{

    public static class Line implements Comparable<Line>{
        int p1, p2;

        public Line(int p1, int p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public int compareTo(Line o){
            return this.p1 - o.p1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Line> lines = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x,y));
        }

        Collections.sort(lines);
        int totalLength = lines.get(0).p2 - lines.get(0).p1;
        int endPoint = lines.get(0).p2; // 마지막 포인트 업데이트
        for(int i = 1; i < N; i++){
            Line curline = lines.get(i);
            if(curline.p1 <= endPoint){
                if(curline.p2 > endPoint){
                    totalLength += curline.p2 - endPoint;
                    endPoint = curline.p2;
                }
            }else{
                totalLength += curline.p2 - curline.p1;
                endPoint = curline.p2;
            }
        }

        System.out.println(totalLength);
        br.close();
    }
}