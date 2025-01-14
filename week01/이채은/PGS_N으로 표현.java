import java.util.*;

class Solution {
    public int solution(int N, int number) {

        // 1번 사용 set, 2번 사용 set, 3번 사용 set ... List 만들기
        // ex. 4번 사용 set = NNNN, 1번 사용 set & 사칙연산 & 3번 사용 set,
        //                2번 사용 set & 사칙연산 & 2번 사용 set, 1번 사용 set & 사칙연산 & 3번 사용 set

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }


        // 1~8 순회 => number가 있으면 해당 수를, 없으면 -1을 return
        if(N == number) return 1;

        int repeat = N;
        dp.get(1).add(N);
        for(int i = 2; i <= 8; i++){

            for(int j = 1; j <= i-1; j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){

                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b != 0) dp.get(i).add(a/b);

                    }
                }
            }
            repeat = repeat*10 + N;
            dp.get(i).add(repeat);
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}