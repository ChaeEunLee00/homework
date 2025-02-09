import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] selected;
    static boolean[] visited;
    static boolean[] finished;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            selected = new int[N];
            visited = new boolean[N];
            finished = new boolean[N];

            count = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                selected[i] = Integer.parseInt(st.nextToken())-1;
                if(i == selected[i]){
                    count++;
                    finished[i] = true;
                }
            }

            for(int i = 0; i < N; i++){
                if(finished[i]) continue;
                dfs(i);
            }

            sb.append(N-count).append('\n');
        }
        System.out.println(sb.toString());
    }


    public static void dfs(int cur){
        if(finished[cur]) return;

        if(visited[cur]){
            count++;
            finished[cur] = true;
        } else{
            visited[cur] = true;
        }

        dfs(selected[cur]);

        visited[cur] = false;
        finished[cur] = true;
    }
}