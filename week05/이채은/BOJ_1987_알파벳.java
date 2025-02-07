import java.io.*;
import java.util.*;

public class Main {
    public static int R;
    public static int C;
    public static int maxLength;
    public static char[][] board;
    public static boolean[][] visited;

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

        visited = new boolean[R][C];
        visited[0][0] = true;

        StringBuilder sb = new StringBuilder();
        sb.append(board[0][0]);

        dfs(0, 0, sb);

        System.out.println(maxLength);
    }

    public static void dfs(int y, int x, StringBuilder sb) {
        for (int d = 0; d < 4; d++) {
            int nextY = y + dY[d];
            int nextX = x + dX[d];

            if (!isValid(nextY, nextX) || visited[nextY][nextX] || isContained(sb, board[nextY][nextX])) {
                maxLength = Math.max(maxLength, sb.length());
                continue;
            }

            visited[nextY][nextX] = true;
            sb.append(board[nextY][nextX]);
            dfs(nextY, nextX, sb);
            visited[nextY][nextX] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 || x < 0 || y >= R || x >= C) return false;
        return true;
    }

    public static boolean isContained(StringBuilder sb, char c) {
        if (sb.indexOf(c + "") == -1) return false;
        return true;
    }
}