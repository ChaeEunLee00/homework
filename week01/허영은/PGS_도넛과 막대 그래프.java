import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] result = new int[4];
        
        // <나가는 간선의 수, 들어오는 간선의 수>
        Map<Integer, int[]> nodeConnections = new HashMap<>();
        
        // 총 노드의 수
        int maxNodeNumber = -1;
        
        for(int i = 0; i < edges.length; i++){
            int[] outgoingNode = nodeConnections.getOrDefault(edges[i][0], new int[2]);
            outgoingNode[0]++;
            nodeConnections.put(edges[i][0], outgoingNode);
            
            int[] incomingNode = nodeConnections.getOrDefault(edges[i][1], new int[2]);
            incomingNode[1]++;
            nodeConnections.put(edges[i][1], incomingNode);
            
            maxNodeNumber = Math.max(maxNodeNumber, Math.max(edges[i][0], edges[i][1]));
        }
        
        for(int i = 1; i <= maxNodeNumber; i++) {
            // 시작점
            if(nodeConnections.get(i)[0] >= 2 && nodeConnections.get(i)[1] == 0){
                result[0] = i;
            }
            
            // 막대 
            else if(nodeConnections.get(i)[0] == 0){
                result[2]++; 
            }
            
            // 8자 
            else if(nodeConnections.get(i)[0] >= 2 && nodeConnections.get(i)[1] >= 2){
                result[3]++; 
            }
        }
        
        // 도넛 
        result[1] = nodeConnections.get(result[0])[0] - result[2] - result[3];
        
        return result;
    }
}
