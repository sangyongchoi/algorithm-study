package study.dfs.q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int size;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        node = new int[size][size];

        for (int i = 0; i < size; i++) {
            final String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                node[i][j] = s.charAt(j) - 'A';
            }
        }

        execute(copy());
        execute(copyGreenToRed());
    }

    private static int[][] copy(){
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = node[i][j];
            }
        }

        return temp;
    }

    private static int[][] copyGreenToRed(){
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (node[i][j] == 17) {
                    temp[i][j] = 6;
                }else {
                    temp[i][j] = node[i][j];
                }
            }
        }

        return temp;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void execute(int[][] copy){
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (copy[i][j] >= 0) {
                    count++;
                    dfs(i, j, copy[i][j], copy);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i, int j, int number, int[][] map) {
        if(i<0 || i>=size || j< 0|| j>= size || map[i][j] < 0 || map[i][j] != number) return;

        map[i][j] = -1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            dfs(x, y, number, map);
        }
    }
}
