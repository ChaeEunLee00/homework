import java.io.*;
import java.util.*;

class Egg {
    int power; // 내구도
    int weight; // 무게

    public Egg(int power, int weight) {
        this.power = power;
        this.weight = weight;
    }
    public static void hit(Egg egg1, Egg egg2) {
        egg1.power -= egg2.weight;
        egg2.power -= egg1.weight;
    }

    public static void reset(Egg egg1, Egg egg2) {
        egg1.power += egg2.weight;
        egg2.power += egg1.weight;
    }

    public static boolean isBroken(Egg egg) {
        return egg.power <= 0;
    }
}

public class Main {

    private static int N, answer;
    private static Egg[] eggs;

    public static void backTracking(int now, int cnt) {
        if(now == N || cnt == N - 1) { // 맨 오른쪽 계란을 든 경우, 나머지 계란이 모두 깨진 경우
            answer = Math.max(answer, cnt);
            return;
        }

        if(Egg.isBroken(eggs[now])) { // 현재 든 계란이 깨진 경우 -> 다음 계란 들기
            backTracking(now + 1, cnt);
            return;
        }

        for(int nxt = 0; nxt < N; nxt++) {
            if(now == nxt || Egg.isBroken(eggs[nxt])) continue;

            Egg.hit(eggs[now], eggs[nxt]); // 계란으로 계란치기

            int brokenCnt = 0;
            if(Egg.isBroken(eggs[now])) brokenCnt++;
            if(Egg.isBroken(eggs[nxt])) brokenCnt++;

            backTracking(now + 1, cnt + brokenCnt);

            Egg.reset(eggs[now], eggs[nxt]); // 원상복구 하기
        }

    }

    public static void main(String[] args) throws IOException{

        // 1. 입력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        eggs = new Egg[N];
        for(int i = 0; i < N; i++){
            String[] input = reader.readLine().split(" ");
            int power = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);
            eggs[i] = new Egg(power, weight);
        }

        // 2. 백트래킹
        backTracking(0, 0);

        // 3. 정답 출력
        System.out.println(answer);

    }
}
