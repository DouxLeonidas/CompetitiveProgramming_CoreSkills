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
            StringTokenizer st = new StringTokenizer(line);
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (s == 0) {
               System.out.println( l == 1 ? 1 : 0);
               continue;
            }
            long res = solve(s, l, 0, new Long[l+1][s+1]);
            System.out.println(res);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   public static long solve(int s, int l, int cur, Long[][] memo) {
      if (l == 0) {
         return cur == s ? 1 : 0;
      }

      if (memo[l][cur] != null) return memo[l][cur];
      memo[l][cur] = 0L;
      long res = 0;
      int start = (cur == 0) ? 1 : 0;
      for (int i = start; i <= 9; ++i) {
         if (cur + i > s) continue;
         res += solve(s, l-1, cur + i, memo);
      }
      memo[l][cur] = res;
      return res;
   }
}