import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] board;
    static int[][] startend;
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];

        board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startend = new int[m][2];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            startend[i][0] = x-1;
            startend[i][1] = y-1;
        }

        dfs(startend[0][0], startend[0][1], 1); 

        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int index){

        if(x == startend[index][0] && y == startend[index][1]){
            if(index == m-1){
                cnt++;
                return;
            }
            index++;
        }
        
        visited[x][y] = true;
        
        for(int k=0; k<4; k++){ // {{-1,0},{1,0},{0,1},{0,-1}};
            int newX = x + dir[k][0];
            int newY = y + dir[k][1];

            if(newX < 0 || newX > n-1 || newY < 0 || newY > n-1 || board[newX][newY]==1 || visited[newX][newY]){
                continue;
            }
        
        //    System.out.println(newX+","+newY);
            dfs(newX, newY, index);
        }
        
        visited[x][y] = false;
    }
}
