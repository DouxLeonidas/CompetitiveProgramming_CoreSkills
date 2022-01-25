import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution1 {

   private static final int WEIGHT = 0;
   private static final int VALUE = 1;

   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] items = new int[n][2];
            for (int i = 0; i < n; ++i) {
               line = br.readLine();
               st = new StringTokenizer(line);
               items[i][WEIGHT] = Integer.parseInt(st.nextToken());
               items[i][VALUE] = Integer.parseInt(st.nextToken());
            }
            knapsack(n, W, items);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   public static void knapsack(int n, int W, int[][] items) {
      int[][] dp = new int[W + 1][n + 1];
      for (int wi = 1; wi <= W; ++wi) {
         for (int it = 1; it <= n; ++it) {
            if (items[it-1][WEIGHT] <= wi) {
               dp[wi][it] = Math.max(dp[wi][it-1], dp[wi-items[it-1][WEIGHT]][it-1] + items[it-1][VALUE]);
            } else {
               dp[wi][it] = dp[wi][it-1];
            }
         }
      }
      /*for (int row = 0; row <= W; ++row) {
         for (int col = 0; col <= n; ++col) {
            System.out.print(dp[row][col] + " ");
         }
         System.out.println();
      }*/
      Stack<Integer> res = new Stack<>();
      int u = W;
      for (int i = n; i > 0; i--) {
         if (dp[u][i] != dp[u][i - 1]) {
            u -= items[i - 1][WEIGHT];
            res.push(i);
         }
      }
      System.out.println(res.size());
      while (!res.isEmpty()) {
         System.out.print(res.pop());
         if (res.size() > 0) {
            System.out.print(" ");
         }
      }
      System.out.println();
   }
}