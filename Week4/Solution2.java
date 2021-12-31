import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution2 {
   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line;
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int minIdx = n+1;
            int maxIdx = 0;
            int minRes = Integer.MAX_VALUE;
            int maxRes = Integer.MIN_VALUE;
            for (int i = 1; i <= n; ++i) {
               int val = Integer.parseInt(br.readLine());
               if (val < minRes) {
                  minRes = val;
                  minIdx = i;
               }
               if (val > maxRes) {
                  maxRes = val;
                  maxIdx = i;
               }
               System.out.print(Math.min(minIdx,maxIdx));
               System.out.print(" ");
               System.out.println(Math.max(minIdx,maxIdx));
            }
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
}