import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int M;
    public static int[][] lab;
    public static ArrayList<Point> virus = new ArrayList<>();

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

        lab = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바이러스 포인트
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(lab[i][j] == 2) virus.add(new Point(i,j));
            }
        }

        // 벽 세우는 경우의 수
        int maxCount = 0;
        for(int a = 0; a < N*M; a++){
            if(lab[a/M][a%M] != 0) continue;
            for(int b = a+1; b < N*M; b++){
                if(lab[b/M][b%M] != 0) continue;
                for(int c = b+1; c < N*M; c++ ){
                    if(lab[c/M][c%M] != 0) continue;

                    // lab 복사
                    int[][] labCopy = copyLab();

                    // 벽 세우기
                    labCopy[a/M][a%M] = 1;
                    labCopy[b/M][b%M] = 1;
                    labCopy[c/M][c%M] = 1;

                    // 바이러스에 대해 bfs(바이러스 전파)
                    bfs(labCopy);

                    // 안전구역 count;
                    int count = countSafeArea(labCopy);
                    if(count > maxCount) maxCount = count;
                }
            }
        }

        System.out.println(maxCount);
        br.close();
    }

    public static int[][] copyLab(){
        int[][] newLab = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                newLab[i][j] = lab[i][j];
            }
        }

        return newLab;
    }
    public static void bfs(int[][] labCopy){
        int[] dY = {1, -1, 0, 0};
        int[] dX = {0, 0, 1, -1};

        for(int i = 0; i < virus.size(); i++){
            Point virusStart = virus.get(i);

            Queue<Point> q = new LinkedList<>();
            q.add(virusStart);
            labCopy[virusStart.y][virusStart.x] = 2;

            while(!q.isEmpty()){
                Point point = q.remove();

                for(int j = 0; j < 4; j++){
                    int nextY = point.y + dY[j];
                    int nextX = point.x + dX[j];

                    if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M &&
                            labCopy[nextY][nextX] == 0){
                        q.add(new Point(nextY, nextX));
                        labCopy[nextY][nextX] = 2;
                    }
                }
            }
        }
    }

    public static int countSafeArea(int[][] labCopy){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(labCopy[i][j] == 0) count++;
            }
        }

        return count;
    }

}