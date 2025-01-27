import java.io.*;
import java.util.*;

public class Main{
    public static int y;
    public static int x;
    public static int result = 0;
    public static int[][] board;
    public static int[][][] visited = new int[19][19][4]; // 방향에 따른 방문여부 체크

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // board
        board = new int[19][19];
        for(int i = 0; i < 19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        gameResult();

        System.out.println(result);
        if(result != 0) System.out.println(y + " " + x);
        br.close();
    }

    public static void gameResult(){
        // 가장 왼쪽 위를 출력해야하기 때문에 왼쪽 열부터 탐색
        for(int j = 0; j < 19; j++){
            for(int i = 0; i < 19; i++){
                if(board[i][j] == 0) continue;

                // 오른쪽, 아래, 오른쪽아래 대각선, 오른쪽위 대각선 방향
                for(int d = 0; d < 4; d++){
                    if(visited[i][j][d] == 0 && count(i,j,d,1) == 5){
                        y = i+1;
                        x = j+1;
                        result = board[i][j];
                        return;
                    }
                }
            }
        }

        result = 0;
        return ;
    }

    public static int count(int y, int x, int d, int cnt){
        visited[y][x][d] = 1;

        // 오른쪽, 아래, 오른쪽아래 대각선, 오른쪽위 대각선 방향
        int[] dY = { 0, 1, 1, -1};
        int[] dX = { 1, 0, 1, 1};

        int nextY = y + dY[d];
        int nextX = x + dX[d];
        if(nextY >= 0 && nextY < 19 && nextX >= 0 && nextX < 19
                && board[y][x] == board[nextY][nextX]){
            return count(nextY,nextX,d,cnt+1);
        }

        return cnt;
    }
}