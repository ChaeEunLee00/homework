import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static boolean[] visited;
    static int[] selectGirls;
    static int answer;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};


    // 7명의 무리가 소문난 칠공주인지 판단하는 메서드
    public static void checkGroup() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedGirls = new boolean[5][5];
        int memberCnt = 1;

        // 시작 학생
        int startX = selectGirls[0] / 5, startY = selectGirls[0] % 5;
        q.offer(new int[]{startX, startY});
        visitedGirls[startX][startY] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; // 범위 확인
                if(visitedGirls[nx][ny]) continue; //

                boolean isGroup = false;
                for(int girl: selectGirls) {
                    if (girl == nx * 5 + ny) {
                        isGroup = true;
                        memberCnt++;
                        break;
                    }
                }

                if(!isGroup) continue;

                visitedGirls[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        if(memberCnt == 7) answer++;
    }

    // 7명 무리 만드는 메서드
    public static void select7Girl(int idx, int yCnt, int totalCnt) {
        if(yCnt >= 4) return; // 임도연파가 네명이면 안됨
        if(totalCnt == 7) {
            checkGroup(); // 7명 결성 - 소문난 칠공주인지 확인
            return;
        }

        for(int i = idx; i < 25; i++){
            visited[i] = true;
            selectGirls[totalCnt] = i;

            if(board[i / 5][i % 5] == 'Y') {
                select7Girl(i + 1, yCnt + 1, totalCnt + 1);
            } else {
                select7Girl(i + 1, yCnt, totalCnt + 1);
            }

            visited[i] = false;
            selectGirls[totalCnt] = -1;
        }

    }

    /*
    * 1. 이다솜파가 4명이상인 7명의 학생을 선택합니다.
    * 2. 인접한 자리에 위치하는지 확인합니다. 
    */
    public static void main(String[] args) throws IOException{
        answer = 0;
        board = new char[5][5];
        visited = new boolean[25];
        selectGirls = new int[7];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        select7Girl(0, 0, 0);

        System.out.println(answer);
    }
}
