import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> reverseEdges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            edges.add(new ArrayList<>());
            reverseEdges.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            edges.get(u).add(v);
            reverseEdges.get(v).add(u);
        }

        /*  S->N->T, T->N->S 를 동시에 만족하는 N을 찾아야함
         *  = S->N, N->T, T->N, N->S 로 나눌 수 있음 (나누는 이유는 끝점 제외 정점을 여러번 방문하는 경우를 고려하기 위함)
         *  = N->T, N->S 같은 경우는 탐색하기 어려움으로 역방향으로 바꾸어 탐색해줌
         *  = 따라서, S->N, T->N(역), T->N, S->N(역) 을 탐색하여 모두 만족하는 N의 갯수를 찾음
         */

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken())-1;
        int T = Integer.parseInt(st.nextToken())-1;

        // S->N
        boolean[] visited1 = new boolean[N];
        dfs(S,T,edges,visited1);

        // T->N(역)
        boolean[] visited2 = new boolean[N];
        dfs(T,-1,reverseEdges,visited2); // S가 끝점이 아니기 때문에 멈출 필요가 없다. -1로 설정

        // T->N
        boolean[] visited3 = new boolean[N];
        dfs(T,S,edges,visited3);

        // S->N(역)
        boolean[] visited4 = new boolean[N];
        dfs(S,-1,reverseEdges,visited4); //T가 끝점이 아니기 때문에 멈출 필요가 없다. -1로 설정

        int answer = 0;
        for(int i = 0; i < N; i++){
            if(visited1[i] && visited2[i] && visited3[i] && visited4[i]) answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(int cur, int end, ArrayList<ArrayList<Integer>> edges, boolean[] visited){
        if(cur == end) return;

        visited[cur] = true;

        ArrayList<Integer> curEdges = edges.get(cur);
        for(int i = 0; i < curEdges.size(); i++){
            int next = curEdges.get(i);
            if(visited[next]) continue;

            dfs(next, end, edges, visited);
        }
    }
}
