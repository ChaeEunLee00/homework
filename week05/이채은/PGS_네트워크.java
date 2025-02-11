class Solution {
    public int n;
    public int[] visited;
    public int[][] computers;

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new int[n];

        int answer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int node){
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}