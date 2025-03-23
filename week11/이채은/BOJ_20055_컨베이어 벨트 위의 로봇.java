import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int K;

    public static class Belt{
        int durability;
        boolean robot;

        public Belt(int durability){
            this.durability = durability;
            this.robot = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        LinkedList<Belt> conveyor = new LinkedList<>();
        for(int i = 0; i < 2*N; i++){
            conveyor.add(i,new Belt(Integer.parseInt(st.nextToken())));
        }

        int step = 0;
        while(K > 0){
            step++;
            // 1. 컨베이어 한칸 회전
            moveConveyor(conveyor);

            // 2. 로봇 이동할 수 있는 경우에 이동 + 내구도 감소
            moveRobot(conveyor);

            // 3. 로봇 올릴 수 있으면 올림
            addRobot(conveyor);
        }

        System.out.println(step);
    }

    public static void moveConveyor(LinkedList<Belt> conveyor){
        conveyor.addFirst(conveyor.removeLast());
        conveyor.get(N-1).robot = false;
    }

    public static void moveRobot(LinkedList<Belt> conveyor){
        for(int i = N-2; i >= 0; i--){
            Belt nextBelt = conveyor.get(i+1);
            Belt curBelt = conveyor.get(i);
            if(curBelt.robot && !nextBelt.robot && nextBelt.durability > 0){
                curBelt.robot = false;
                nextBelt.robot = true;
                if(--nextBelt.durability == 0) K--;
            }
        }
        conveyor.get(N-1).robot = false;
    }

    public static void addRobot(LinkedList<Belt> conveyor){
        Belt inBelt = conveyor.get(0);
        if(!inBelt.robot && inBelt.durability > 0) {
            inBelt.robot = true;
            if(--inBelt.durability == 0) K--;
        }
    }
}