public class Main {
    public static void main(final String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = split[0];
        int col = split[1];

        String[] map = new String[row];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine();
        }

        List<int[]> ghosts = new ArrayList<>();
        int[] namwoo = new int[2];
        
        for (int r = 0; r < map.length; r++) {
            final String line = map[r];

            final char[] charArray = line.toCharArray();

            for (int c = 0; c < charArray.length; c++) {
                final char ch = charArray[c];
                if (ch == 'N') { //남우
                    namwoo = new int[]{r, c};
                } else if (ch == 'G') { //유령
                    ghosts.add(new int[]{r, c});
                }
            }
        }

        int namwooTime = bfs(map, namwoo, false);
        
        int ghostTime = Integer.MAX_VALUE;
        for (final int[] ghost : ghosts) {
            ghostTime = Math.min(ghostTime, bfs(map, ghost, true));
        }
        
        if (namwooTime == -1) {
            System.out.println("No");
            return;
        }
        
        System.out.println(ghostTime <= namwooTime ? "No" : "Yes");
    }

    private static int bfs(final String[] map, final int[] obj, final boolean isWallPass) {
        int[][] directions = new int[][]{
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        boolean[][] isVisited = new boolean[map.length][map[0].length()];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{obj[0], obj[1], 0});
        isVisited[obj[0]][obj[1]] = true;

        while (!dq.isEmpty()) {
            final int[] cur = dq.pollFirst();
            if (map[cur[0]].charAt(cur[1]) == 'D') {
                return cur[2];
            }

            for (final int[] direction : directions) {
                final int nextRow = cur[0] + direction[0];
                final int nextCol = cur[1] + direction[1];

                if (isOut(map, nextRow, nextCol)) {
                    continue;
                }
                if (isVisited[nextRow][nextCol]) {
                    continue;
                }
              
                if (!isWallPass && map[nextRow].charAt(nextCol) == '#') {
                    continue;
                }

                isVisited[nextRow][nextCol] = true;
                dq.addLast(new int[]{nextRow, nextCol, cur[2] + 1});
            }
        }

        return -1;
    }

    private static boolean isOut(final String[] map, final int row, final int col) {
        return row < 0 || row >= map.length || col < 0 || col >= map[0].length();
    }
}
