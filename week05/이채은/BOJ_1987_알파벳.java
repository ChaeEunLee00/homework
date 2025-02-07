import java.io.*;
import java.util.*;

public class Main {
    public static int R;
    public static int C;
    public static int maxLength;
    public static char[][] board;
    public static boolean[] abcVisited = new boolean[26];

    public static int[] dY = {1, -1, 0, 0};
    public static int[] dX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 알파벳 별 방문여부 체크를 통한 메모리,시간 개선
        abcVisited[board[0][0]-'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxLength);
    }

    public static void dfs(int y, int x, int length) {
        for (int d = 0; d < 4; d++) {
            int nextY = y + dY[d];
            int nextX = x + dX[d];

            if (!isValid(nextY, nextX) || abcVisited[board[nextY][nextX]-'A']){
                maxLength = Math.max(maxLength, length);
                continue;
            }

            abcVisited[board[nextY][nextX]-'A'] = true;
            dfs(nextY, nextX, length+1);
            abcVisited[board[nextY][nextX]-'A'] = false;
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return false;
        return true;
    }
}