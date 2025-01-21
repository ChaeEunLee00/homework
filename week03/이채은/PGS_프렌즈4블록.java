import java.util.*;

class Solution {
    public static int M;
    public static int N;
    public static int score = 0;
    public static Character[][] Board;

    public static class Point{
        int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        Board = new Character[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                Board[i][j] = board[i].charAt(j);
            }
        }

        ArrayList<Point> removablePoint = findremovablePoint();
        while(!removablePoint.isEmpty()){
            // 블록 제거 (+ 점수계산)
            removePoint(removablePoint);

            // 보드 업데이트
            updateBoard();

            // 업데이트 된 보드에 대해 다시 remoableList 탐색
            removablePoint = findremovablePoint();
        }

        return score;
    }
    public ArrayList<Point> findremovablePoint(){
        ArrayList<Point> removablePoints = new ArrayList<>();
        for(int i = 0; i < M-1; i++){
            for(int j = 0; j < N-1; j++){
                Character c = Board[i][j];
                if(c != ' ' && c == Board[i+1][j] &&
                        c == Board[i][j+1] && c == Board[i+1][j+1]){
                    removablePoints.add(new Point(i,j));
                    removablePoints.add(new Point(i+1,j));
                    removablePoints.add(new Point(i,j+1));
                    removablePoints.add(new Point(i+1,j+1));
                }
            }
        }
        return removablePoints;
    }

    public void removePoint(ArrayList<Point> removablePoint){
        for(int i = 0; i < removablePoint.size(); i++){
            Point point = removablePoint.get(i);
            if(Board[point.y][point.x] != ' '){
                Board[point.y][point.x] = ' ';
                score++;
            }
        }
    }

    public void updateBoard(){
        // 열에 대해 탐색
        for(int n = 0; n < N; n++){
            Queue<Character> columnValues = new LinkedList<>();

            for(int m = 0; m < M; m++){
                if(Board[m][n] != ' ') columnValues.add(Board[m][n]);
            }

            int idx = columnValues.size();
            if(idx == 0) continue;

            for(int i = 0; i < M - idx; i++){
                Board[i][n] = ' ';
            }

            for(int i = M - idx; i < M; i++){
                Board[i][n] = columnValues.remove();
            }
        }
    }
}