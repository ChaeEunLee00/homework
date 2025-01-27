import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        recursion(0, 0, N);
        System.out.println(sb);
    }


    static void recursion(int x, int y, int len) {
        boolean isSame = true;
        int num = map[x][y];
        loop:
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (num != map[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }
        if (isSame) {
            sb.append(num);
            return;
        }

        sb.append("(");
        int nlen = len / 2;
        recursion(x, y, nlen);
        recursion(x, y + nlen, nlen);
        recursion(x + nlen, y, nlen);
        recursion(x + nlen, y + nlen, nlen);
        sb.append(")");
    }
}
