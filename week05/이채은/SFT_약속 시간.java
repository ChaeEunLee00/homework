import java.io.*;
import java.util.*;

public class Main {

    // 연속확률 분포
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        // 전체 공간 부피
        int totalVolume = 60 * 60 * 60; // 216000

        // 사건이 발생하는 부피
        int validVolume = (M * M * M) + (3 * M * M * (60 - M));

        // 확률을 기약분수로 출력하기 위해 최대공약수(GCD)로 약분
        int divisor = gcd(validVolume, totalVolume);

        // 분자와 분모를 GCD로 나누어 기약분수 형태로 출력
        System.out.println((validVolume / divisor) + "/" + (totalVolume / divisor));
    }

    // 최대공약수(GCD) 계산 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
