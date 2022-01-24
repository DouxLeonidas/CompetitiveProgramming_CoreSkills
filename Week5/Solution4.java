import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution4 {
   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[] arr = new int[n];
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n; ++i) {
               arr[i] = Integer.parseInt(st.nextToken());
            }
            int steps = solve(n, arr);
            System.out.println(steps);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   private static int solve(int n, int[] arr) {
      int m = 0;
      for (int i = 0; i < n; ++i) {
         m = Math.max(m, arr[i]);
      }
      int[][] dp = new int[n + 1][m + 1];
      dp[0][0] = 0;

      for (int i = 0; i < n; ++i) {
         int bestBelow = Integer.MAX_VALUE;
         for (int j = 0; j <= m; ++j) {
            bestBelow = Math.min(bestBelow, dp[i][j]);
            dp[i + 1][j] = bestBelow + Math.abs(arr[i] - j);
         }
      }

      int res = Integer.MAX_VALUE;
      for (int i = 0; i <= m; i++) {
         res = Math.min(res, dp[n][i]);
      }

      return res;
   }
}