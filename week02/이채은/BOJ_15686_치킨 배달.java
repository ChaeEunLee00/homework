import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int M;
    public static int[] opened;
    public static ArrayList<Point> homes = new ArrayList<>();
    public static ArrayList<Point> chickens = new ArrayList<>();
    public static ArrayList<Integer> distances = new ArrayList<>();


    public static class Point{
        int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                String currentPoint = st.nextToken();
                if(currentPoint.equals("1")){
                    Point point = new Point(i,j);
                    homes.add(point);
                }
                else if(currentPoint.equals("2")){
                    Point point = new Point(i,j);
                    chickens.add(point);
                }
            }
        }

        opened = new int[chickens.size()];
        bt(0);

        Collections.sort(distances);
        System.out.println(distances.get(0));
        br.close();
    }

    public static void bt(int idx){
        if(M == 0){
            int distance = calculateD();
            distances.add(distance);
            return;
        } else if(idx == opened.length) return;

        for(int i = idx; i < opened.length; i++){
            if(opened[i] == 0){
                opened[i] = 1;
                M--;
                bt(i+1);
                opened[i] = 0;
                M++;
            }
        }
    }

    public static int calculateD(){
        //오픈 치킨 포인트
        ArrayList<Point> openChickens = new ArrayList<>();
        for(int i = 0; i < opened.length; i++){
            if(opened[i] == 1) openChickens.add(chickens.get(i));
        }

        //집을 순회하며 가장 가까운 치킨집 거리 구하기 -> 모두 더함
        int sumDistance = 0;
        for(int i = 0; i < homes.size(); i++){
            int homeY = homes.get(i).y;
            int homeX = homes.get(i).x;

            int minDistance = Integer.MAX_VALUE;
            for(int j = 0; j < openChickens.size(); j++){
                int chickenY = openChickens.get(j).y;
                int chickenX = openChickens.get(j).x;

                int distance = Math.abs(homeY-chickenY) + Math.abs(homeX-chickenX);
                if(distance < minDistance) minDistance = distance;
            }
            sumDistance += minDistance;
        }
        return sumDistance;
    }
}