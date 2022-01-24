import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution1 {
   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
               a[i] = Integer.parseInt(st.nextToken());
            }
            int lis = longestIncreasingSubsequence(a, n);
            System.out.println(lis);
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   private static int longestIncreasingSubsequence(int[] a, int n) {
      int[] dp = new int[n];
      Arrays.fill(dp, 1);

      for (int i = 0; i < n; ++i) {
         for (int j = 0; j < i; ++j) {
            if (a[j] < a[i] && dp[i] < dp[j] + 1) {
               dp[i] = dp[j] + 1;
            }
         }
      }

      int lis = 1;
      for (int i = 0; i < n; ++i) {
         lis = Math.max(dp[i], lis);
      }

      return lis;
   }
}