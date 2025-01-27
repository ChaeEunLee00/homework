import java.io.*;
import java.util.*;

public class Main{
    public static int N;
    public static int[] students;
    public static int[][] favorites;
    public static int[][] classroom;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        students = new int[N*N];
        favorites = new int[N*N+1][4];
        classroom = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N*N; i++){
            st = new StringTokenizer(br.readLine());
            students[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 4; j++){
                favorites[students[i]][j] = Integer.parseInt(st.nextToken());
            }
        }

        placeStudent();

        System.out.println(calculateSatisfaction());
        br.close();
    }

    public static void placeStudent(){
        for(int i = 0; i < N*N; i++){
            int student = students[i];

            ArrayList<Integer[]> list = new ArrayList<Integer[]>();

            // 좋아하는 학생이 인접한 칸에 많은 칸 리스트
            list = findMostFavorite(list, student);
            // 그 중 비어있는 칸이 많은 칸 리스트
            list = findMostEmpty(list);
            // 그 중 행이 가장 작은 칸
            list = findMinRow(list);
            // 그 중 열이 가장 작은 칸
            list = findMinColumn(list);

            // 배정
            Integer[] seat = list.get(0);
            classroom[seat[0]][seat[1]] = student;

        }
    }
    public static ArrayList<Integer[]> findMostFavorite(ArrayList<Integer[]> list, int student){
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(classroom[i][j] != 0) continue;

                int count = countFavorite(i,j,student);
                if(count > max){
                    max = count;
                    list.clear();
                    list.add(new Integer[]{i,j});
                }
                else if (count == max){
                    list.add(new Integer[]{i,j});
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer[]> findMostEmpty(ArrayList<Integer[]> list){
        if(list.size() == 1) return list;
        ArrayList<Integer[]> temp = new ArrayList<Integer[]>();

        int max = 0;
        for(int i =0; i < list.size(); i++){
            Integer[] p = list.get(i);

            int count = countEmpty(p[0], p[1]);
            if(count > max){
                max = count;
                temp.clear();
                temp.add(p);
            }
            else if(count == max){
                temp.add(p);
            }
        }
        return temp;
    }

    public static int countEmpty(int i, int j){
        int[] dY = {1, -1, 0, 0};
        int[] dX = {0, 0, 1, -1};


        int num = 0;
        for(int d = 0; d < 4; d++){
            int nextY = i + dY[d];
            int nextX = j + dX[d];
            if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < N &&
                    classroom[nextY][nextX] == 0){
                num++;
            }
        }
        return num;
    }

    public static ArrayList<Integer[]> findMinRow(ArrayList<Integer[]> list){
        if(list.size() == 1) return list;
        ArrayList<Integer[]> temp = new ArrayList<Integer[]>();

        int min = N;
        for(int i =0; i < list.size(); i++){
            Integer[] p = list.get(i);

            if(p[0] < min){
                min = p[0];
                temp.clear();
                temp.add(p);
            }
            else if(p[0] == min){
                temp.add(p);
            }
        }
        return temp;
    }

    public static ArrayList<Integer[]> findMinColumn(ArrayList<Integer[]> list){
        if(list.size() == 1) return list;
        ArrayList<Integer[]> temp = new ArrayList<Integer[]>();

        int min = N;
        for(int i =0; i < list.size(); i++){
            Integer[] p = list.get(i);

            if(p[1] < min){
                min = p[1];
                temp.clear();
                temp.add(p);
            }
            else if(p[1] == min){
                temp.add(p);
            }
        }
        return temp;
    }

    public static int calculateSatisfaction(){
        int satisfaction = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = countFavorite(i,j,classroom[i][j]);

                if(num == 1) satisfaction += 1;
                else if(num == 2) satisfaction += 10;
                else if(num == 3) satisfaction += 100;
                else if(num == 4) satisfaction += 1000;
            }
        }
        return satisfaction;
    }

    public static int countFavorite(int i, int j, int student){
        int[] dY = {1, -1, 0, 0};
        int[] dX = {0, 0, 1, -1};


        int num = 0;
        for(int d = 0; d < 4; d++){
            int nextY = i + dY[d];
            int nextX = j + dX[d];
            if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < N &&
                    contains(classroom[nextY][nextX], favorites[student])){
                num++;
            }
        }
        return num;
    }

    public static boolean contains(int student, int[] favorite){
        for(int i = 0; i < 4; i++){
            if(favorite[i] == student) return true;
        }
        return false;
    }
}