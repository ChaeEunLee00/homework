import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] video = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                video[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        System.out.println(quadTree(video));
        br.close();
    }

    static String quadTree(int[][] video){
        //전체가 1이거나 0 이면 1이나 0 반환
        if(isAll(video,1)) return "1";
        else if(isAll(video,0)) return "0";

        StringBuilder sb = new StringBuilder();

        // 4분면에 대해 quadTree
        int N = video.length;

        sb.append("(");
        sb.append(quadTree( makeVideo(video,0,0) ));
        sb.append(quadTree( makeVideo(video,0,N/2) ));
        sb.append(quadTree( makeVideo(video,N/2,0) ));
        sb.append(quadTree( makeVideo(video,N/2,N/2) ));
        sb.append(")");

        return sb.toString();
    }

    static boolean isAll(int[][] video, int num){
        if(num == 1){
            for(int i = 0; i < video.length; i++){
                for(int j = 0; j < video.length; j++){
                    if(video[i][j] != 1) return false;
                }
            }
        }
        else if(num == 0){
            for(int i = 0; i < video.length; i++){
                for(int j = 0; j < video.length; j++){
                    if(video[i][j] != 0) return false;
                }
            }
        }

        return true;
    }

    static int[][] makeVideo(int[][] video, int x, int y){
        int N = video.length;
        int[][] newVideo = new int[N/2][N/2];

        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2; j++){
                newVideo[i][j] = video[i + x][j + y];
            }
        }

        return newVideo;
    }
}