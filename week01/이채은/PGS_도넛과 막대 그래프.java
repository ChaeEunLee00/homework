import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        // 생성된 정점: out 2, in x  (1)
        // 막대: out x (2)
        // 8자: out 2, in 2개 이상  (3)
        // 도넛: out 1, in 1개 이상 (4) = (1) - (2) - (3)


        // 정점별 out, in 수 저장
        Map<Integer, int[]> nodes = new HashMap<>();
        for(int[] edge: edges){
            if(!nodes.containsKey(edge[0])){
                nodes.put(edge[0], new int[]{0,0});
            }

            if(!nodes.containsKey(edge[1])){
                nodes.put(edge[1], new int[]{0,0});
            }

            nodes.get(edge[0])[0]++;
            nodes.get(edge[1])[1]++;
        }

        // 생성된 정점 찾기
        for(Map.Entry<Integer, int[]> node : nodes.entrySet()){
            if(node.getValue()[0] >= 2 && node.getValue()[1] == 0){
                answer[0] = node.getKey();
            }
        }

        // 생성된 정점 간선 수 저장 후
        int totalGraphNum = nodes.get(answer[0])[0];

        // 막대그래프 수 찾기
        for(Map.Entry<Integer, int[]> node : nodes.entrySet()){
            if(node.getValue()[0] == 0){
                answer[2]++;
            }
        }

        // 8자 그래프 수 찾기
        for(Map.Entry<Integer, int[]> node : nodes.entrySet()){
            if(node.getValue()[0] == 2 && node.getValue()[1] >= 2){
                answer[3]++;
            }
        }

        answer[1] = totalGraphNum - answer[2] - answer[3];

        return answer;
    }
}