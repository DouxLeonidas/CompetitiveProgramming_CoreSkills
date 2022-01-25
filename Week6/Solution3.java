import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution3 {
   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[] a = readArray(n, br.readLine());
            int[] b = readArray(n, br.readLine());
            solve(n, a, b);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   private static void solve(int n, int[] a, int[] b) {
      int[][] dp = new int[n+1][n+1];
      for (int r = 1; r <= n; ++r) {
         for (int c = 1; c <= n; ++c) {
            if (a[r-1] == b[c-1]) {
               dp[r][c] = dp[r-1][c-1] + 1;
            } else {
               if (dp[r-1][c] >= dp[r][c-1]) {
                  dp[r][c] = dp[r-1][c];
               } else {
                  dp[r][c] = dp[r][c-1];
               }
            }
            //System.out.print(dp[r][c] + " ");
         }
         //System.out.println();
      }
      System.out.println(dp[n][n]);
      //Reconstruct
      StringBuilder solA = new StringBuilder();
      StringBuilder solB = new StringBuilder();
      int i = n;
      int j = n;
      while (i > 0 && j > 0) {
         if (a[i-1] == b[j-1]) {
            if (solA.length() > 0) {
               solA.insert(0, " ");
               solB.insert(0, " ");
            }
            solA.insert(0, Integer.toString(i-1));
            solB.insert(0, Integer.toString(j-1));
            i--; j--;
         } else {
            if (dp[i-1][j] == dp[i][j]) {
               i--;
            } else {
               j--;
            }
         }
      }
      System.out.println(solA.toString());
      System.out.println(solB.toString());
   }

   private static int[] readArray(int n, String readLine) {
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(readLine);
      for (int i = 0; i < n; ++i) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      return arr;
   }
}