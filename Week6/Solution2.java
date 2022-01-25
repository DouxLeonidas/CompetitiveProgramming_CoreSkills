import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution2 {
   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[] mat = new int[n + 1];
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n + 1; i++) {
               mat[i] = Integer.parseInt(st.nextToken());
            }
            solve(n + 1, mat);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   private static void solve(int n, int[] mat) {
      long[][] dp = new long[n][n];
      for (int i = 0; i < n; i++) {
         Arrays.fill(dp[i], Long.MAX_VALUE);
         if(i < n - 1) dp[i][i+1] = 0;
      }
      n -= 1;
      for (int s = 2; s <= n; ++s) {
         for (int i = 0; i < (n - s + 1); ++i) {
            int j = i + s;
            for (int k = i+1; k < j; ++k) {
               //System.out.println(i + " " + j + " " + k);
               long prod = mat[i] * mat[j] * mat[k];
               long val = dp[i][k] + dp[k][j] + prod;
               dp[i][j] = Math.min(dp[i][j], val);
            }
         }
      }
      System.out.println(dp[0][n]);
   }
}