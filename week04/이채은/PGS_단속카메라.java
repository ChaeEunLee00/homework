import java.util.*;

class Solution {

    public class Route implements Comparable<Route>{
        int in, out;
        public Route(int in, int out){
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(Route o){
            return this.out - o.out;
        }
    }

    public int solution(int[][] routes) {
        // 진출 기준 오름차순 정렬
        ArrayList<Route> routeList = new ArrayList<>();
        for(int i = 0; i < routes.length; i++){
            routeList.add(new Route(routes[i][0], routes[i][1]));
        }
        Collections.sort(routeList);

        // 경로안에 카메라가 있으면 패스
        // 경로안에 카메라가 없으면 진출지점에 카메라
        int answer = 1;
        int lastCamera = routeList.get(0).out;
        for(int i = 1; i < routeList.size(); i++){
            Route r = routeList.get(i);
            if(lastCamera < r.in){
                answer++;
                lastCamera = r.out;
            }
        }

        return answer;
    }
}