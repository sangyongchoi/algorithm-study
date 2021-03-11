package study.dynamic.q14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        int N = Integer.parseInt(br.readLine());

        int[][] node = new int[N + 10][N + 10];
        int[] dp = new int[N+10];
        int max = 0;
        String[] str;
        for (int i = 1; i <=N; i++) {
            str = br.readLine().split(" ");
            node[i][0] = Integer.parseInt(str[0]);
            node[i][1] = Integer.parseInt(str[1]);
        }


        for (int i = 1; i <=N+1; i++) {
            int[] tmp = node[i];
            dp[i] = Math.max(dp[i], max);
            dp[tmp[0]+i] = Math.max(dp[tmp[0]+i],tmp[1]+dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
