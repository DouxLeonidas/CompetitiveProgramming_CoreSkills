import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            String u = br.readLine();
            String w = br.readLine();
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int i = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            System.out.println(editDistance(u, w, i, d, s));
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   private static int editDistance(String a, String b, int iCost, int dCost, int sCost) {
      int an = a.length();
      int bn = b.length();
      int[][] dp = new int[an + 1][bn + 1];

      for (int i = 1; i <= an; ++i) {
         dp[i][0] = i * dCost;
      }

      for (int i = 1; i <= bn; ++i) {
         dp[0][i] = i * iCost;
      }

      char[] ac = a.toCharArray();
      char[] bc = b.toCharArray();
      for (int row = 1; row <= an; row++) {
         for (int col = 1; col <= bn; col++) {
            int diff = ac[row-1] == bc[col-1] ? 0 : sCost;
            dp[row][col] = Math.min(dp[row-1][col] + dCost,
                    dp[row][col-1] + iCost);
            dp[row][col] = Math.min(dp[row][col],
                    dp[row-1][col-1] + diff);
         }
      }

      return dp[an][bn];
   }
}