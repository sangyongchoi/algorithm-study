package study.dfs.q2667;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] map = new int[count][count];
        int result = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<count; i++){
            String input = sc.next();
            for(int j=0; j<count; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (map[i][j] == 1) {
                    result = dfs(map, i, j, count);
                    list.add(result);
                }
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] map, int i, int j, int size) {
        if(i<0 || i>= size || j<0 || j>=size || map[i][j] == 0 ) return 0;

        map[i][j] = 0;
        int result = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            result += dfs(map, x, y, size);
        }

        return result;
    }
}
